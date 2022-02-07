package com.qa.marvelqa.service;

import com.qa.marvelqa.domain.MarvelCharacter;
import com.qa.marvelqa.exceptions.CharacterNotFoundException;
import com.qa.marvelqa.repo.CharacterRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarvelCharacterService implements ServiceCRUD<MarvelCharacter> {


    private final CharacterRepo repo;

    public MarvelCharacterService(CharacterRepo repo) {
        this.repo = repo;
    }

    public MarvelCharacter create(MarvelCharacter character) {
        return this.repo.saveAndFlush(character);
    }

    public List<MarvelCharacter> getAll() {
        return this.repo.findAll();
    }

    public MarvelCharacter getById(Long id) {
        return this.repo.findById(id).orElseThrow(CharacterNotFoundException::new);
    }

    //Custom - get by ability
    public List<MarvelCharacter> getByAbility(String mainAbility) {
        return this.repo.findByAbility(mainAbility).orElseThrow();
    }

    public MarvelCharacter update(Long id, MarvelCharacter character) {
        MarvelCharacter existing = this.repo.findById(id).orElseThrow(CharacterNotFoundException::new);
        existing.setCharactersName(character.getCharactersName());
        existing.setAlias(character.getAlias());
        existing.setMainAbility(character.getMainAbility());
        existing.setActorsName(character.getActorsName());
        existing.setActorsDOB(character.getActorsDOB());
        return this.repo.saveAndFlush(existing);
    }

    public boolean delete(Long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }
}
