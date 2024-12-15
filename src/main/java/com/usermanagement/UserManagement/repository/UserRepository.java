package com.usermanagement.UserManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usermanagement.UserManagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    List<User> findByName(String name);
    List<User> findBySurname(String surname);
    User findByEmail(String email);
    List<User> findByAge(int age);
}
