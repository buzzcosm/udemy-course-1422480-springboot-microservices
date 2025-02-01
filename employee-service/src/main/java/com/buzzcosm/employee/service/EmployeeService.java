package com.buzzcosm.employee.service;

import com.buzzcosm.employee.dto.APIResponseDto;
import com.buzzcosm.employee.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}