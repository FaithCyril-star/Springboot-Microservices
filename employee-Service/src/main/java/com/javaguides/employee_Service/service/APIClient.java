package com.javaguides.employee_Service.service;

import com.javaguides.employee_Service.dto.departmentdto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{departmentCode}")
    DepartmentDto getDepartmentByCode(@PathVariable String departmentCode);
}
