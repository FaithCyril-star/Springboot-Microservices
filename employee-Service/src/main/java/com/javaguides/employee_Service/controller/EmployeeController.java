package com.javaguides.employee_Service.controller;

import com.javaguides.employee_Service.dto.apiresponsedto.APIResponseDto;
import com.javaguides.employee_Service.dto.employeedto.EmployeeDto;
import com.javaguides.employee_Service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto = employeeService.save(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("{employee-id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("employee-id") Long id){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
}
