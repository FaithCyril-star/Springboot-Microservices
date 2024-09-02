package com.javaguides.employee_Service.service;

import com.javaguides.employee_Service.dto.apiresponsedto.APIResponseDto;
import com.javaguides.employee_Service.dto.employeedto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);
}
