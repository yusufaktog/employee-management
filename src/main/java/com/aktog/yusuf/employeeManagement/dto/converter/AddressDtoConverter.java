package com.aktog.yusuf.employeeManagement.dto.converter;

import com.aktog.yusuf.employeeManagement.dto.AddressDto;
import com.aktog.yusuf.employeeManagement.entity.Address;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressDtoConverter {
    public AddressDto convert(Address from){
        return new AddressDto(
                from.getId(),
                from.getCountry(),
                from.getCity(),
                from.getBuildingNumber(),
                from.getApartmentNumber(),
                from.getZipCode(),
                from.getEmployee().getId()
        );
    }
    public List<AddressDto> convert(List<Address> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
