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

}
