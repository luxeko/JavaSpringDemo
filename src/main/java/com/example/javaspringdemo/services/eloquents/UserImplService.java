package com.example.javaspringdemo.services.eloquents;

import com.example.javaspringdemo.entities.Education;
import com.example.javaspringdemo.entities.User;
import com.example.javaspringdemo.repositories.UserRepository;
import com.example.javaspringdemo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserImplService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getOneUserById(int id) {
        return userRepository.findById(id);
    }
}
