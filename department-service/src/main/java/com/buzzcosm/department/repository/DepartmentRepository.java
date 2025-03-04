package com.buzzcosm.department.repository;

import com.buzzcosm.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDepartmentCode(String departmentCode);
}
