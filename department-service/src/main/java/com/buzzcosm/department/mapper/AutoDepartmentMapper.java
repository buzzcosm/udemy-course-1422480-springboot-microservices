package com.buzzcosm.department.mapper;

import com.buzzcosm.department.dto.DepartmentDto;
import com.buzzcosm.department.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {
    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    DepartmentDto mapToDepartmentDto(Department department);
    Department mapToDepartmentEntity(DepartmentDto departmentDto);
}
