package com.wasthDevocde.JIAT_Codefest.Service;

import com.wasthDevocde.JIAT_Codefest.Model.WikiKeyWords;
import com.wasthDevocde.JIAT_Codefest.Repositries.WordRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WikiService {
    @Autowired
    WordRepositry wordRepositry;

    public List<WikiKeyWords> getAllWords() {
        return wordRepositry.findAll();
    }

    public List<WikiKeyWords> getWikiKeyWordsByDescription(String Name){
        return wordRepositry.getWikiKeyWordsByDescription(Name);
    }
}
