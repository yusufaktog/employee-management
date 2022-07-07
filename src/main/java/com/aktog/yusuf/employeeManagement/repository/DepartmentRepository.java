package com.aktog.yusuf.employeeManagement.repository;

import com.aktog.yusuf.employeeManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,String> {
}
