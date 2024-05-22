package com.example.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {
	private int id;
    private String name;
    private int age;
    private String gender;
    private Department department;
}
