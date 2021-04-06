package com.wasthDevocde.JIAT_Codefest.repositories;

import com.wasthDevocde.JIAT_Codefest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUsername(String username);
}
