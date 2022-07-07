package com.aktog.yusuf.employeeManagement.dto.converter;

import com.aktog.yusuf.employeeManagement.dto.DepartmentDto;
import com.aktog.yusuf.employeeManagement.entity.Department;
import com.aktog.yusuf.employeeManagement.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DepartmentDtoConverter {

    public DepartmentDto convert(Department from) {
        return new DepartmentDto(
                from.getId(),
                from.getName(),
                from.getCreationDate(),
                Optional.ofNullable(from.getEmployees())
                        .orElse(new HashSet<>())
                        .stream()
                        .map(Employee::getId)
                        .collect(Collectors.toSet())
        );
    }

    public List<DepartmentDto> convert(List<Department> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
