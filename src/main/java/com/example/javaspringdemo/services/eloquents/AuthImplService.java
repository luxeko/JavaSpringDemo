package com.example.javaspringdemo.services.eloquents;

import com.example.javaspringdemo.entities.User;
import com.example.javaspringdemo.repositories.UserRepository;
import com.example.javaspringdemo.services.interfaces.IAuthService;
import com.example.javaspringdemo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AuthImplService implements IAuthService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean checkLogin(String username, String password) {
        return false;
    }
}
