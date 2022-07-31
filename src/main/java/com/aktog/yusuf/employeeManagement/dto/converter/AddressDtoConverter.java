package com.aktog.yusuf.employeeManagement.dto.converter;

import com.aktog.yusuf.employeeManagement.dto.AddressDto;
import com.aktog.yusuf.employeeManagement.entity.Address;
import com.aktog.yusuf.employeeManagement.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AddressDtoConverter {
    public AddressDto convert(Address from) {
        return new AddressDto(
                from.getId(),
                from.getCountry(),
                from.getCity(),
                from.getStreet(),
                from.getBuildingNumber(),
                from.getApartmentNumber(),
                from.getZipCode(),
                Optional.ofNullable(from.getEmployees())
                        .orElse(new HashSet<>())
                        .stream()
                        .map(Employee::getId)
                        .collect(Collectors.toSet())

        );
    }

    public List<AddressDto> convert(List<Address> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
