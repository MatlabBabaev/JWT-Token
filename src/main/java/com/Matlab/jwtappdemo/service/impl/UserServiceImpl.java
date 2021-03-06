package com.Matlab.jwtappdemo.service.impl;

import com.Matlab.jwtappdemo.model.Role;
import com.Matlab.jwtappdemo.model.Status;
import com.Matlab.jwtappdemo.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;

import com.Matlab.jwtappdemo.model.User;
import com.Matlab.jwtappdemo.repository.UserRepository;
import com.Matlab.jwtappdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j //logging
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();

        userRoles.add(roleUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registeredUser = userRepository.save(user);

        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
