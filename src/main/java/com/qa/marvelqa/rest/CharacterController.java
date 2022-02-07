package com.qa.marvelqa.rest;

import com.qa.marvelqa.domain.MarvelCharacter;
import com.qa.marvelqa.service.MarvelCharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marvel-char")
public class CharacterController {


    private final MarvelCharacterService service;

    public CharacterController(MarvelCharacterService service) {
        this.service = service;
    }

    //Create
    @PostMapping("/create")
    public ResponseEntity<MarvelCharacter> create(@RequestBody MarvelCharacter character) {
        return new ResponseEntity<>(this.service.create(character), HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/getAll")
    public ResponseEntity<List<MarvelCharacter>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.FOUND);
    }

    //By ID
    @GetMapping("/get/{id}")
    public ResponseEntity<MarvelCharacter> getById(@PathVariable Long id){
        return new ResponseEntity<>(this.service.getById(id), HttpStatus.FOUND);
    }


    //Update
    @PutMapping("/update/{id}")
    public ResponseEntity<MarvelCharacter> update(@PathVariable Long id, @RequestBody MarvelCharacter character){
        return new ResponseEntity<>(this.service.update(id, character), HttpStatus.ACCEPTED);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MarvelCharacter> delete(@PathVariable Long id){
        return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
