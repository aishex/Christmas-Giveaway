package com.usermanagement.UserManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.UserManagement.model.Address;
import com.usermanagement.UserManagement.model.Role;
import com.usermanagement.UserManagement.model.User;
import com.usermanagement.UserManagement.repository.AddressRepository;
import com.usermanagement.UserManagement.repository.RoleRepository;
import com.usermanagement.UserManagement.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AddressRepository addressRepository;

    
    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @PostMapping
public User createUser(@RequestBody User user) {

    System.out.println("Otrzymano użytkownika: " + user);

    if (user.getRole() != null && user.getRole().getId() != null) {
        Role role = roleRepository.findById(user.getRole().getId())
            .orElseThrow(() -> new RuntimeException("Role not found with id: " + user.getRole().getId()));
        user.setRole(role);
    } else {
        user.setRole(null);
    }

    if (user.getAddress() != null && user.getAddress().getId() != null) {
        Address address = addressRepository.findById(user.getAddress().getId())
            .orElseThrow(() -> new RuntimeException("Address not found with id: " + user.getAddress().getId()));
        user.setAddress(address);
    } else {
        user.setAddress(null);
    }

    System.out.println("Zapisz użytkownika: " + user);
    return userRepository.save(user);
}

    


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }
    


}
