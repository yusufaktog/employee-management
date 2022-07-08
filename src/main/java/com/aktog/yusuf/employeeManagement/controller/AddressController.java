package com.aktog.yusuf.employeeManagement.controller;

import com.aktog.yusuf.employeeManagement.dto.AddressDto;
import com.aktog.yusuf.employeeManagement.dto.request.create.CreateAddressRequest;
import com.aktog.yusuf.employeeManagement.dto.request.update.UpdateAddressRequest;
import com.aktog.yusuf.employeeManagement.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@Valid @RequestBody CreateAddressRequest request) {
        return new ResponseEntity<>(addressService.createAddress(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable String addressId) {
        return ResponseEntity.ok(addressService.deleteAddressById(addressId));
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable String addressId,
                                                    @Valid @RequestBody UpdateAddressRequest request) {
        return ResponseEntity.ok(addressService.updateAddress(addressId, request));

    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable String addressId){
        return ResponseEntity.ok(addressService.getAddressById(addressId));
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddressList(){
        return ResponseEntity.ok(addressService.getAddressDtoList());
    }


}
