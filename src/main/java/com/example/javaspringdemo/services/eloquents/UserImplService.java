package com.example.javaspringdemo.services.eloquents;

import com.example.javaspringdemo.entities.Education;
import com.example.javaspringdemo.entities.User;
import com.example.javaspringdemo.repositories.UserRepository;
import com.example.javaspringdemo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserImplService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getOneUser(int id) {
        return userRepository.findById(id);
    }
}
