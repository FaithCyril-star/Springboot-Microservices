package com.javaguides.department_Service.mapper;

import com.javaguides.department_Service.dto.DepartmentDto;
import com.javaguides.department_Service.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);
    Department mapToDepartment(DepartmentDto departmentDto);

    DepartmentDto mapToDepartmentDto(Department department);
}
