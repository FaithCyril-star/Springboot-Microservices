package com.javaguides.employee_Service.service.EmployeeServiceImpl;

import com.javaguides.employee_Service.employeedto.EmployeeDto;
import com.javaguides.employee_Service.entity.Employee;
import com.javaguides.employee_Service.mapper.EmployeeMapper;
import com.javaguides.employee_Service.repository.EmployeeRepository;
import com.javaguides.employee_Service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        return employeeDto;
    }
}
