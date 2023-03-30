package com.example.javaspringdemo.services.eloquents;

import com.example.javaspringdemo.entities.User;
import com.example.javaspringdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> op = userRepository.findUserByEmail(email);
        System.out.println(email);
        if (op.isPresent()) {
            User user = op.get();
            List<GrantedAuthority> grandtList = new ArrayList<GrantedAuthority>();
            GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
            grandtList.add(authority);
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(), grandtList);
        } else {
            throw new UsernameNotFoundException("Login Fail !");
        }
    }
}
