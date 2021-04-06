package com.wasthDevocde.JIAT_Codefest.controller;

import com.wasthDevocde.JIAT_Codefest.model.WikiKeyWords;
import com.wasthDevocde.JIAT_Codefest.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
