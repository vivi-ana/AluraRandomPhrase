package com.aluracursos.screenmatch_phrase.service;

import com.aluracursos.screenmatch_phrase.model.PhraseDTO;
import com.aluracursos.screenmatch_phrase.model.Phrase;
import com.aluracursos.screenmatch_phrase.repository.PhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling operations related to phrases.
 */
@Service
public class PhraseService {
    @Autowired
    private PhraseRepository phraseRepository;

    /**
     * Retrieves a random phrase DTO.
     * @return A PhraseDTO object representing a random phrase.
     */
    public PhraseDTO getRandomPhrase() {
        Phrase phrase = phraseRepository.getRandomPhrase();
        return new PhraseDTO(phrase.getTitle(), phrase.getPhrase(), phrase.getCharacter(), phrase.getPoster());
    }
}
