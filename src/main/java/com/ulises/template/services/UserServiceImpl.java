package com.ulises.template.services;

import com.ulises.template.services.entities.User;
import com.ulises.template.services.exceptions.UserNotFoundException;
import com.ulises.template.services.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void getUser(User user) {
        if(!this.userRepository.existsById(user.getUsername()))
            throw new UserNotFoundException();
    }
}
