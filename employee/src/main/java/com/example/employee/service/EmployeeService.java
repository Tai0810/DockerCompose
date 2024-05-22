package com.example.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.employee.dto.Department;
import com.example.employee.dto.EmployeeDTO;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<EmployeeDTO> getAllEmployee() {
    	List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
        employeeRepository.findAll().forEach((s)->{
            Department department = restTemplate.getForObject("http://department-service:8081/department/get/"+s.getDepartmentID(),Department.class);
            list.add(new EmployeeDTO(s.getId(),s.getName(),s.getAge(),s.getGender(),department));
        });
        return list;
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}
