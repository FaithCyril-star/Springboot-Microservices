package com.javaguides.employee_Service.service;

import com.javaguides.employee_Service.employeedto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
}
