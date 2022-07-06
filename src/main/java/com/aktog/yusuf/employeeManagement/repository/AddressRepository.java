package com.aktog.yusuf.employeeManagement.repository;

import com.aktog.yusuf.employeeManagement.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
