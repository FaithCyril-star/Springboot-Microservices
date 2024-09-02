package com.javaguides.employee_Service.dto.apiresponsedto;

import com.javaguides.employee_Service.dto.employeedto.EmployeeDto;
import com.javaguides.employee_Service.dto.departmentdto.DepartmentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
}