package com.aktog.yusuf.employeeManagement.repository;

import com.aktog.yusuf.employeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
