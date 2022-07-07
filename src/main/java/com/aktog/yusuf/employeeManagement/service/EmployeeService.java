package com.aktog.yusuf.employeeManagement.service;

import com.aktog.yusuf.employeeManagement.dto.AddressDto;
import com.aktog.yusuf.employeeManagement.dto.EmployeeDto;
import com.aktog.yusuf.employeeManagement.dto.converter.EmployeeDtoConverter;
import com.aktog.yusuf.employeeManagement.dto.request.create.CreateEmployeeRequest;
import com.aktog.yusuf.employeeManagement.dto.request.update.UpdateEmployeeRequest;
import com.aktog.yusuf.employeeManagement.entity.Address;
import com.aktog.yusuf.employeeManagement.entity.Department;
import com.aktog.yusuf.employeeManagement.entity.Employee;
import com.aktog.yusuf.employeeManagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
                .orElseThrow(() -> new EntityNotFoundException("Employee id : " + employeeId + " not found"));
    }

    public EmployeeDto getByEmployeeId(String employeeId) {
        return employeeDtoConverter.convert(findByEmployeeId(employeeId));
    }

    public String deleteEmployeeById(String employeeId) {
        findByEmployeeId(employeeId);

        return "Employee id : " + employeeId + " deleted";
    }

    public EmployeeDto createEmployee(CreateEmployeeRequest request) {
        Department department = departmentService.findByDepartmentId(request.getDepartmentId());
        Employee employee = new Employee(
                request.getName(),
                request.getSurname(),
                department
        );
        return employeeDtoConverter.convert(employeeRepository.save(employee));
    }

    public EmployeeDto UpdateEmployeeRequest(String employeeId, UpdateEmployeeRequest request) {
        Employee employee = findByEmployeeId(employeeId);
        
        List<String> addressIds = Optional.ofNullable(request.getAddressIds()).orElse(new ArrayList<>());
        
        Employee updatedEmployee = new Employee(
                employeeId,
                request.getName(),
                request.getSurname(),
                addressIds.isEmpty() 
                        ? employee.getAddresses() 
                        : addressIds.stream().map(addressService::findByAddressId).collect(Collectors.toSet()),
                Optional.ofNullable(departmentService.findByDepartmentId(request.getDepartmentId()))
                        .orElse(employee.getDepartment())

        );
        return employeeDtoConverter.convert(employeeRepository.save(updatedEmployee));
    }
    
    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }

    public List<EmployeeDto> getEmployeeDtoList(){
        return employeeDtoConverter.convert(getEmployeeList());
    }

}
