package com.aktog.yusuf.employeeManagement.controller;


import com.aktog.yusuf.employeeManagement.dto.EmployeeDto;
import com.aktog.yusuf.employeeManagement.dto.request.create.CreateEmployeeRequest;
import com.aktog.yusuf.employeeManagement.dto.request.update.UpdateEmployeeRequest;
import com.aktog.yusuf.employeeManagement.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/{addressId}/{departmentId}")
    public ResponseEntity<EmployeeDto> createEmployee(
            @PathVariable String addressId,
            @PathVariable String departmentId,
            @Valid @RequestBody CreateEmployeeRequest request) {
        return new ResponseEntity<>(employeeService.createEmployee(addressId,departmentId,request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId) {
        return ResponseEntity.ok(employeeService.deleteEmployeeById(employeeId));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable String employeeId,
                                                      @Valid @RequestBody UpdateEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId, request));

    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String employeeId) {
        return ResponseEntity.ok(employeeService.getByEmployeeId(employeeId));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getEmployeeDtoList());
    }
}
