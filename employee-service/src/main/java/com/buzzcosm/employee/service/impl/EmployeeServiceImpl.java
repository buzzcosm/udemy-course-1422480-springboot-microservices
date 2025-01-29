package com.buzzcosm.employee.service.impl;

import com.buzzcosm.employee.dto.EmployeeDto;
import com.buzzcosm.employee.entity.Employee;
import com.buzzcosm.employee.exception.EmailAlreadyExistsException;
import com.buzzcosm.employee.exception.ResourceNotFoundException;
import com.buzzcosm.employee.mapper.AutoEmployeeMapper;
import com.buzzcosm.employee.repository.EmployeeRepository;
import com.buzzcosm.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDto.getEmail());

        if (optionalEmployee.isPresent()) {
            throw new EmailAlreadyExistsException("Email Already Exists for Employee");
        }

        //Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployeeEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        //return modelMapper.map(savedEmployee, EmployeeDto.class);
        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
        //return modelMapper.map(employee, EmployeeDto.class);
        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
    }
}
