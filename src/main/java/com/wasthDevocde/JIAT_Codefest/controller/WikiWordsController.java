package com.wasthDevocde.JIAT_Codefest.controller;

import com.wasthDevocde.JIAT_Codefest.model.WikiKeyWords;
import com.wasthDevocde.JIAT_Codefest.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/words")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class WikiWordsController {

    @Autowired
    WikiService wikiService;

    @GetMapping("{name}")
    public List<WikiKeyWords> getUserLikeName(@PathVariable String name){
          return wikiService.getWikiKeyWordsByDescription(name);
    }

    @PostMapping
    public HashMap<String, Object> saveUsers(WikiKeyWords users){
//        return userService.addUser(users);

        WikiKeyWords user1 = wikiService.saveWords(users);

        HashMap<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("data", user1);
        response.put("message", "Success");

        return response;

    }

    @DeleteMapping("{id}")
    public String deleteWord(@PathVariable Integer id) {
        return wikiService.deleteWord(id);
    }
}
