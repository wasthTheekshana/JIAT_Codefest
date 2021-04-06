package com.wasthDevocde.JIAT_Codefest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class WikiKeyWords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String keyword;
    String description;

    public WikiKeyWords() {

    }

    public WikiKeyWords(int id, String keyword, String description) {
        this.id = id;
        this.keyword = keyword;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
