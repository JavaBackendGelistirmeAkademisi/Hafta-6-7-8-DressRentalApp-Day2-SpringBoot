package com.example.dressrentalapp.service;

import com.example.dressrentalapp.exception.ValidationException;
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
    private final CartService cartService;

    @Autowired
    public UserService(UserRepository userRepository, CartService cartService) {
        this.userRepository = userRepository;
        this.cartService = cartService;
    }

    // Yeni kullanıcı ekleme
    public User addUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())){
            throw new ValidationException("Bu email ile kayıtlı kullanıcı bulunmaktadır.");
        }
        User savedUser = userRepository.save(user);
        cartService.saveEmptyCart(savedUser);
        return savedUser;
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
