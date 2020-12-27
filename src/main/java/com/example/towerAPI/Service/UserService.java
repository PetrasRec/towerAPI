package com.example.towerAPI.Service;

import com.example.towerAPI.exeption.ResourceNotFoundException;
import com.example.towerAPI.model.User;
import com.example.towerAPI.model.UserLogin;
import com.example.towerAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public long logIn(UserLogin userLoginInfo) throws ResourceNotFoundException {
        var user = userRepository.getUserByEmail(userLoginInfo.email);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        var encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(userLoginInfo.password, user.getPassword())) {
            throw new ResourceNotFoundException("Bad password");
        }
        return user.getId();
    }

    public User addNewUser(User user) {
        if(user.isGuest()) {
            return userRepository.save(user);
        }

        var encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUserById(Long id) throws ResourceNotFoundException {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
