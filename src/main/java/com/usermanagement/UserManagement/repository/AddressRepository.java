package com.usermanagement.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.UserManagement.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
