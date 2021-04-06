package com.wasthDevocde.JIAT_Codefest.Repositries;

import com.wasthDevocde.JIAT_Codefest.Model.WikiKeyWords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WordRepositry extends JpaRepository<WikiKeyWords, Integer> {

    @Query("SELECT u FROM WikiKeyWords u WHERE u.keyword LIKE %?1%")
    public List<WikiKeyWords> getWikiKeyWordsByDescription(String name);


}
