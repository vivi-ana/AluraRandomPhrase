package com.aluracursos.screenmatch_phrase.repository;

import com.aluracursos.screenmatch_phrase.model.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository interface for managing Phrase entities.
 */
public interface PhraseRepository extends JpaRepository<Phrase, Long> {

    /**
     * Retrieves a random phrase from the database.
     * @return A Phrase object representing a random phrase.
     */
    @Query("SELECT p FROM Phrase p Order by function('RANDOM') LIMIT 1")
    Phrase getRandomPhrase();

}
