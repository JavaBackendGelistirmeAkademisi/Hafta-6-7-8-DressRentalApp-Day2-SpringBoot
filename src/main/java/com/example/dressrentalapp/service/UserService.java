package com.example.dressrentalapp.service;

import com.example.dressrentalapp.model.User;
import com.example.dressrentalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Kullanıcı servisi, kullanıcı işlemlerini yönetir
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Yeni kullanıcı ekleme
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    // Tüm kullanıcıları listeleme
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ID ile kullanıcı bulma
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
