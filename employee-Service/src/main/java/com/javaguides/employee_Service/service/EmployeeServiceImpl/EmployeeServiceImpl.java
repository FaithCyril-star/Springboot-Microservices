package com.javaguides.employee_Service.service.EmployeeServiceImpl;

import com.javaguides.employee_Service.dto.apiresponsedto.APIResponseDto;
import com.javaguides.employee_Service.dto.departmentdto.DepartmentDto;
import com.javaguides.employee_Service.dto.employeedto.EmployeeDto;
import com.javaguides.employee_Service.entity.Employee;
import com.javaguides.employee_Service.exception.ResourceNotFoundException;
import com.javaguides.employee_Service.mapper.EmployeeMapper;
import com.javaguides.employee_Service.repository.EmployeeRepository;
import com.javaguides.employee_Service.service.APIClient;
import com.javaguides.employee_Service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private APIClient webclient;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        try{
        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;}
        catch(Exception exception){
            throw new RuntimeException("Problem occurred while saving employee data");
        }
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee","id",id));
        DepartmentDto departmentDto  = webclient.getDepartmentByCode(employee.getDepartmentCode());
        EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        System.out.println(departmentDto);
        System.out.println(apiResponseDto);
        return apiResponseDto;


    }
}
