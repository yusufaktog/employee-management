package com.aktog.yusuf.employeeManagement.controller;

import com.aktog.yusuf.employeeManagement.dto.AddressDto;
import com.aktog.yusuf.employeeManagement.dto.DepartmentDto;
import com.aktog.yusuf.employeeManagement.dto.request.create.CreateDepartmentRequest;
import com.aktog.yusuf.employeeManagement.dto.request.update.UpdateAddressRequest;
import com.aktog.yusuf.employeeManagement.dto.request.update.UpdateDepartmentRequest;
import com.aktog.yusuf.employeeManagement.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/{addressId}")
    public ResponseEntity<DepartmentDto> createDepartment(@PathVariable String addressId, @Valid @RequestBody CreateDepartmentRequest request) {
        return new ResponseEntity<>(departmentService.createDepartment(addressId, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable String departmentId) {
        return ResponseEntity.ok(departmentService.deleteDepartmentById(departmentId));
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable String departmentId,
                                                          @Valid @RequestBody UpdateDepartmentRequest request) {
        return ResponseEntity.ok(departmentService.updateDepartment(departmentId, request));
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable String departmentId) {
        return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getDepartmentDtoList());
    }
}
