package com.buzzcosm.employee.service.impl;

import com.buzzcosm.employee.dto.APIResponseDto;
import com.buzzcosm.employee.dto.DepartmentDto;
import com.buzzcosm.employee.dto.EmployeeDto;
import com.buzzcosm.employee.entity.Employee;
import com.buzzcosm.employee.exception.EmailAlreadyExistsException;
import com.buzzcosm.employee.exception.ResourceNotFoundException;
import com.buzzcosm.employee.mapper.AutoEmployeeMapper;
import com.buzzcosm.employee.repository.EmployeeRepository;
import com.buzzcosm.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${department.api.url}")
    private String departmentApiUrl;

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
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity(departmentApiUrl + employee.getDepartmentCode(), DepartmentDto.class);

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
