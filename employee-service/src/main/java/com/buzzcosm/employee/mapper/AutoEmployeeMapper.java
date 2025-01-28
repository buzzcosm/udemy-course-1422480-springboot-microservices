package com.buzzcosm.employee.mapper;

import com.buzzcosm.employee.dto.EmployeeDto;
import com.buzzcosm.employee.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {
    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    EmployeeDto mapToEmployeeDto(Employee employee);
    Employee mapToEmployeeEntity(EmployeeDto employeeDto);
}
