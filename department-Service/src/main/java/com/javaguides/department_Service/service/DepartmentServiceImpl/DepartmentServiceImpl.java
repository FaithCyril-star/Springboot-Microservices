package com.javaguides.department_Service.service.DepartmentServiceImpl;

import com.javaguides.department_Service.dto.DepartmentDto;
import com.javaguides.department_Service.entity.Department;
import com.javaguides.department_Service.exception.ResourceNotFoundException;
import com.javaguides.department_Service.mapper.DepartmentMapper;
import com.javaguides.department_Service.repository.DepartmentRepository;
import com.javaguides.department_Service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        try{
        Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
        }
        catch(Exception exception){
            throw new RuntimeException("An error was encountered when saving department");
        }
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(() -> new ResourceNotFoundException("Department","departmentCode",departmentCode));
        DepartmentDto departmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(department);
        return departmentDto;
        }
}
