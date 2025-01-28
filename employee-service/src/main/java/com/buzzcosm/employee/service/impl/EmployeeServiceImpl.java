package com.buzzcosm.employee.service.impl;

import com.buzzcosm.employee.dto.EmployeeDto;
import com.buzzcosm.employee.entity.Employee;
import com.buzzcosm.employee.repository.EmployeeRepository;
import com.buzzcosm.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
