package com.wasthDevocde.JIAT_Codefest.repositories;

import com.wasthDevocde.JIAT_Codefest.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Members, Integer> {
}
