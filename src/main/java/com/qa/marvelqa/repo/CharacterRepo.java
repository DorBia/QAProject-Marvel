package com.qa.marvelqa.repo;

import com.qa.marvelqa.domain.MarvelCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepo extends JpaRepository<MarvelCharacter, Long> {

}
