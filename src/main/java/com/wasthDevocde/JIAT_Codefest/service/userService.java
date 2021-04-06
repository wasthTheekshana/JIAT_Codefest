package com.wasthDevocde.JIAT_Codefest.service;

import com.wasthDevocde.JIAT_Codefest.model.User;
import com.wasthDevocde.JIAT_Codefest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public User saveUser(User u) {
        return userRepository.save(u);
    }


    public User updateUser(User u) {
        User avlUser = userRepository.findById(u.getId()).orElse(u);
        if (avlUser != null) {
            avlUser.setUsername(u.getUsername());
            avlUser.setPassword(u.getPassword());
        }

        return userRepository.save(avlUser);
    }

    public String deleteUser(Integer id) {
        User avlUser = userRepository.findById(id).orElse(null);
        if (avlUser != null) {
            userRepository.delete(avlUser);
        }

        return "User - " + id + " Deleted";
    }

    public User getUserById(Integer id) {
        User avlUser = userRepository.findById(id).orElse(null);
        return avlUser;
    }

    public List<User> getUsersByUserName(String username) {
        return userRepository.findByUsername(username);
    }

}
