package com.qa.marvelqa.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class MarvelCharacter {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please enter the character's name")
    private String charactersName;

    @NotNull(message = "Please enter the alias")
    private String alias;

    @NotNull(message = "Please enter the main ability")
    private String mainAbility;

    @NotNull(message = "Please enter a full name")
    private String actorsName;

    @Column(name = "actors_DOB", nullable = false)
    @Past(message = "the date must be in the past")
    private LocalDate actorsDOB;

    @Transient
    private int age;

    public MarvelCharacter() {
    }

    public MarvelCharacter(Long id, String fullName, String alias, String mainAbility,
                           String actorsName, LocalDate actorsDOB) {
        this.id = id;
        this.charactersName = fullName;
        this.alias = alias;
        this.mainAbility = mainAbility;
        this.actorsName = actorsName;
        this.actorsDOB = actorsDOB;
    }

    public MarvelCharacter(String fullName, String alias, String mainAbility,
                           String actorsName, LocalDate actorsDOB) {
        this.charactersName = fullName;
        this.alias = alias;
        this.mainAbility = mainAbility;
        this.actorsName = actorsName;
        this.actorsDOB = actorsDOB;
    }

    //Constructor to test setting and getting the age
    public MarvelCharacter(Long id, String charactersName, String alias,
                           String mainAbility, String actorsName,
                           LocalDate actorsDOB, int age) {
        this.id = id;
        this.charactersName = charactersName;
        this.alias = alias;
        this.mainAbility = mainAbility;
        this.actorsName = actorsName;
        this.actorsDOB = actorsDOB;
        this.age = age;
    }
}
