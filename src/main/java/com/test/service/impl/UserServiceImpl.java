package com.test.service.impl;

import com.test.Repository.UserRepository;
import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findUserByUserName(username);
    }
}
