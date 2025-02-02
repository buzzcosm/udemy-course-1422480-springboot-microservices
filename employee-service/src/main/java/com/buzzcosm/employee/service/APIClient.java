package com.buzzcosm.employee.service;

import com.buzzcosm.employee.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${department.service.url}", value = "${department.service.name}")
public interface APIClient {

    @GetMapping("${department.service.api-prefix}/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}
