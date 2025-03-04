package com.buzzcosm.department.service.impl;

import com.buzzcosm.department.dto.DepartmentDto;
import com.buzzcosm.department.entity.Department;
import com.buzzcosm.department.exception.DepartmentCodeAlreadyExistsException;
import com.buzzcosm.department.exception.ResourceNotFoundException;
import com.buzzcosm.department.mapper.AutoDepartmentMapper;
import com.buzzcosm.department.repository.DepartmentRepository;
import com.buzzcosm.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Optional<Department> optionalDepartment = departmentRepository.findByDepartmentCode(departmentDto.getDepartmentCode());

        if (optionalDepartment.isPresent()) {
            throw new DepartmentCodeAlreadyExistsException("Department code " + departmentDto.getDepartmentCode() + " already exists");
        }

        //Department department = modelMapper.map(departmentDto, Department.class);
        Department department = AutoDepartmentMapper.MAPPER.mapToDepartmentEntity(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        //return modelMapper.map(savedDepartment, DepartmentDto.class);
        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                () -> new ResourceNotFoundException("Department", "code", departmentCode));
        //return modelMapper.map(department, DepartmentDto.class);
        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }
}
