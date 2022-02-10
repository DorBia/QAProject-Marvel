package com.qa.marvelqa.repo;

import com.qa.marvelqa.domain.MarvelCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepo extends JpaRepository<MarvelCharacter, Long>{

    @Query(value = "SELECT * FROM marvel_character WHERE main_ability = ?1", nativeQuery = true)
    Optional<List<MarvelCharacter>> findByAbility(String main_Ability);

}
