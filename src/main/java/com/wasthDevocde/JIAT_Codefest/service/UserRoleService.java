package com.wasthDevocde.JIAT_Codefest.service;

import com.wasthDevocde.JIAT_Codefest.model.UserRole;
import com.wasthDevocde.JIAT_Codefest.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    public List<UserRole> getUserRoles(){
        return userRoleRepository.findAll();
    }

    public UserRole updateUserRole(UserRole role){
        UserRole userRole = userRoleRepository.findById(role.getId()).orElse(null);
        if(userRole != null){
            userRole.setDescription(role.getDescription());
            userRole.setRole(role.getRole());
        }
        return userRole;
    }

    public UserRole addUserRole(UserRole role){
        return userRoleRepository.save(role);
    }
}
