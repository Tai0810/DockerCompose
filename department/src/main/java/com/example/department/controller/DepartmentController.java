package com.example.department.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save")
	public Department save(@RequestBody Department department){
        return departmentService.saveProduct(department);
    }

    @GetMapping("/get/{id}")
    public Optional<Department> getById(@PathVariable int id){
        return  departmentService.getDepartmentById(id);
    }
}
