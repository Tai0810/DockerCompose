package com.example.department.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveProduct(Department department){
        return departmentRepository.save(department);
    }

    public Optional<Department> getDepartmentById(int id){
        return departmentRepository.findById(id);
    }
}
