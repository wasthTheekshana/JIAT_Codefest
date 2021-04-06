package com.wasthDevocde.JIAT_Codefest.repositories;

import com.wasthDevocde.JIAT_Codefest.model.WikiKeyWords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WordRepositry extends JpaRepository<WikiKeyWords, Integer> {

    @Query("SELECT u FROM WikiKeyWords u WHERE u.keyword LIKE %?1%")
    public List<WikiKeyWords> getWikiKeyWordsByDescription(String name);


}
