package com.aktog.yusuf.employeeManagement.service;

import com.aktog.yusuf.employeeManagement.dto.EmployeeDto;
import com.aktog.yusuf.employeeManagement.dto.converter.EmployeeDtoConverter;
import com.aktog.yusuf.employeeManagement.dto.request.create.CreateEmployeeRequest;
import com.aktog.yusuf.employeeManagement.dto.request.update.UpdateEmployeeRequest;
import com.aktog.yusuf.employeeManagement.entity.Address;
import com.aktog.yusuf.employeeManagement.entity.Department;
import com.aktog.yusuf.employeeManagement.entity.Employee;
import com.aktog.yusuf.employeeManagement.exception.EmployeeNotFoundException;
import com.aktog.yusuf.employeeManagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeDtoConverter employeeDtoConverter;
    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;
    private final AddressService addressService;

    public EmployeeService(EmployeeDtoConverter employeeDtoConverter,
                           EmployeeRepository employeeRepository,
                           DepartmentService departmentService,
                           AddressService addressService) {
        this.employeeDtoConverter = employeeDtoConverter;
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
        this.addressService = addressService;
    }

    public Employee findByEmployeeId(String employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee id : " + employeeId + " not found"));
    }

    public EmployeeDto getByEmployeeId(String employeeId) {
        return employeeDtoConverter.convert(findByEmployeeId(employeeId));
    }

    public String deleteEmployeeById(String employeeId) {
        findByEmployeeId(employeeId);
        employeeRepository.deleteById(employeeId);
        return "Employee id : " + employeeId + " deleted";
    }

    public EmployeeDto createEmployee(String addressId, String departmentId, CreateEmployeeRequest request) {
        Department department = departmentService.findByDepartmentId(departmentId);
        Address address  = addressService.findByAddressId(addressId);

        HashSet<Address> addresses = (HashSet<Address>) Set.of(address);

        Employee employee = new Employee(
                request.getName(),
                request.getSurname(),
                request.getSalary(),
                addresses,
                department
        );

        addresses = null;

        return employeeDtoConverter.convert(employeeRepository.save(employee));
    }

    public EmployeeDto updateEmployee(String employeeId, UpdateEmployeeRequest request) {
        Employee employee = findByEmployeeId(employeeId);

        List<String> addressIds = Optional.ofNullable(request.getAddressIds()).orElse(new ArrayList<>());

        Employee updatedEmployee = new Employee(
                employeeId,
                request.getName(),
                request.getSurname(),
                request.getSalary(),
                addressIds.isEmpty()
                        ? employee.getAddresses()
                        : addressIds.stream().map(addressService::findByAddressId).collect(Collectors.toSet()),
                Optional.ofNullable(departmentService.findByDepartmentId(request.getDepartmentId()))
                        .orElse(employee.getDepartment())

        );
        return employeeDtoConverter.convert(employeeRepository.save(updatedEmployee));
    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public List<EmployeeDto> getEmployeeDtoList() {
        return employeeDtoConverter.convert(getEmployeeList());
    }

}
