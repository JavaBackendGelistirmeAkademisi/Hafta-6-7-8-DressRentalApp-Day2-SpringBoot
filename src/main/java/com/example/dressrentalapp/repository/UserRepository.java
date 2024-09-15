package com.example.dressrentalapp.repository;

import com.example.dressrentalapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// User için JPA repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
