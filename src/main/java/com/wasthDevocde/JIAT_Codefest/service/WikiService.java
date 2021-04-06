package com.wasthDevocde.JIAT_Codefest.service;

import com.wasthDevocde.JIAT_Codefest.model.WikiKeyWords;
import com.wasthDevocde.JIAT_Codefest.repositories.WordRepositry;
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

    ///save keywords
    public WikiKeyWords saveWords(WikiKeyWords u){
        return wordRepositry.save(u);
    }

    //search keywords
    public List<WikiKeyWords> getWikiKeyWordsByDescription(String Name){
        return wordRepositry.getWikiKeyWordsByDescription(Name);
    }

    //update keywords
    public WikiKeyWords updateKeyword(WikiKeyWords u) {
        WikiKeyWords userreUpdate = wordRepositry.findById(u.getId()).orElse(null);
        if (userreUpdate != null) {
            userreUpdate.setKeyword(u.getKeyword());
            userreUpdate.setDescription(u.getDescription());
        }
        return userreUpdate;
    }

    //delete keywords
    public String deleteWord(Integer id) {
        WikiKeyWords avlUser = wordRepositry.findById(id).orElse(null);
        if (avlUser != null) {
            wordRepositry.delete(avlUser);
        }

        return "Word - " + id + " Deleted";
    }
}
