package com.aluracursos.screenmatch_phrase.controller;

import com.aluracursos.screenmatch_phrase.model.PhraseDTO;
import com.aluracursos.screenmatch_phrase.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling phrases.
 */
@RestController
public class PhraseController {

    @Autowired
    private PhraseService phraseService;

    /**
     * Retrieves a random phrase.
     * @return A PhraseDTO object representing a random phrase.
     */
    @GetMapping("/series/phrase")
    public PhraseDTO getRandomPhrase(){
        return phraseService.getRandomPhrase();

    }

}
