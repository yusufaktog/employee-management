package com.aktog.yusuf.employeeManagement.dto.converter;

import com.aktog.yusuf.employeeManagement.dto.EmployeeDto;
import com.aktog.yusuf.employeeManagement.entity.Address;
import com.aktog.yusuf.employeeManagement.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDtoConverter {

    public EmployeeDto convert(Employee from) {
        return new EmployeeDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getSalary(),
                from.getAddresses()
                        .stream()
                        .map(Address::getId)
                        .collect(Collectors.toSet()),
                from.getDepartment().getId()
        );
    }

    public List<EmployeeDto> convert(List<Employee> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
