package com.wasthDevocde.JIAT_Codefest.repositories;

import com.wasthDevocde.JIAT_Codefest.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface userRepositri extends JpaRepository<Members , Integer> {

    List<Members> findByName(String name);
}
