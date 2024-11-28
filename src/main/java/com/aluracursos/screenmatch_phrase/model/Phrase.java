package com.aluracursos.screenmatch_phrase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing a phrase.
 */
@Entity
public class Phrase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String phrase;
    private String character;
    private String poster;

    public String getTitle() {
        return title;
    }

    public String getPhrase() {
        return phrase;
    }

    public String getCharacter() {
        return character;
    }

    public String getPoster() {
        return poster;
    }
}
