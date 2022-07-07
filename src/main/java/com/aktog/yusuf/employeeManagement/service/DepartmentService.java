package com.aktog.yusuf.employeeManagement.service;

import com.aktog.yusuf.employeeManagement.dto.DepartmentDto;
import com.aktog.yusuf.employeeManagement.dto.converter.DepartmentDtoConverter;
import com.aktog.yusuf.employeeManagement.dto.request.create.CreateDepartmentRequest;
import com.aktog.yusuf.employeeManagement.dto.request.update.UpdateDepartmentRequest;
import com.aktog.yusuf.employeeManagement.entity.Department;
import com.aktog.yusuf.employeeManagement.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentDtoConverter departmentDtoConverter;

    private final AddressService addressService;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentDtoConverter departmentDtoConverter, AddressService addressService) {
        this.departmentRepository = departmentRepository;
        this.departmentDtoConverter = departmentDtoConverter;
        this.addressService = addressService;
    }

    public Department findByDepartmentId(String departmentId) {
       return departmentRepository.findById(departmentId)
               .orElseThrow(() -> new EntityNotFoundException("Address id : " + departmentId + " could not found"));
    }

    public DepartmentDto getDepartmentById(String departmentId) {
        return departmentDtoConverter.convert(findByDepartmentId(departmentId));
    }

    public String deleteDepartmentById(String departmentId){
        findByDepartmentId(departmentId);
        return "Department id : " + departmentId + " deleted";
    }

    public DepartmentDto createDepartment(CreateDepartmentRequest request){
        Department department  = new Department(
                request.getName(),
                request.getCreationDate()
        );
        return departmentDtoConverter.convert(departmentRepository.save(department));
    }

    public DepartmentDto updateDepartment(String departmentId,UpdateDepartmentRequest request){
         Department department = findByDepartmentId(departmentId);

         Department updatedDepartment = new Department(
                 departmentId,
                 request.getName(),
                 department.getCreationDate(),
                 addressService.findByAddressId(Optional.ofNullable(request.getAddressId())
                         .orElse(department.getAddress().getId()))

         );
         return departmentDtoConverter.convert(departmentRepository.save(updatedDepartment));
    }

    public List<Department> getDepartmentList(){
        return departmentRepository.findAll();
    }
    public List<DepartmentDto> getDepartmentDtoList(){
        return departmentDtoConverter.convert(getDepartmentList());
    }
}
