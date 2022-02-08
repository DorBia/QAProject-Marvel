package com.qa.marvelqa.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
public class MarvelCharacter {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please enter the character's name.")
    private String charactersName;

    @NotNull(message = "Please enter the alias.")
    private String alias;

    @NotNull(message = "Please enter the main ability.")
    private String mainAbility;

    @NotNull(message = "Please enter a full name of the actor.")
    private String actorsName;

    @Column(name = "actors_DOB", nullable = false)
    @Past(message = "The date must be in the past.")
    private LocalDate actorsDOB;

    @Transient
    private int age;

    public MarvelCharacter() {
    }

    public MarvelCharacter(String fullName, String alias, String mainAbility,
                           String actorsName, LocalDate actorsDOB) {
        this.charactersName = fullName;
        this.alias = alias;
        this.mainAbility = mainAbility;
        this.actorsName = actorsName;
        this.actorsDOB = actorsDOB;
    }

    //Constructors for testing

    public MarvelCharacter(Long id, String fullName, String alias, String mainAbility,
                           String actorsName, LocalDate actorsDOB) {
        this.id = id;
        this.charactersName = fullName;
        this.alias = alias;
        this.mainAbility = mainAbility;
        this.actorsName = actorsName;
        this.actorsDOB = actorsDOB;
    }

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

    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharactersName() {
        return charactersName;
    }

    public void setCharactersName(String fullName) {
        this.charactersName = fullName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMainAbility() {
        return mainAbility;
    }

    public void setMainAbility(String mainAbility) {
        this.mainAbility = mainAbility;
    }

    public String getActorsName() {
        return actorsName;
    }

    public void setActorsName(String actorsName) {
        this.actorsName = actorsName;
    }

    public LocalDate getActorsDOB() {
        return actorsDOB;
    }

    public void setActorsDOB(LocalDate actorsDOB) {
        this.actorsDOB = actorsDOB;
    }

    public int getAge() {
        return Period.between(this.actorsDOB, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = Period.between(this.actorsDOB, LocalDate.now()).getYears();
    }

    //Hash and equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarvelCharacter that = (MarvelCharacter) o;
        return age == that.age && Objects.equals(id, that.id) && charactersName.equals(that.charactersName) &&
                alias.equals(that.alias) && mainAbility.equals(that.mainAbility) &&
                actorsName.equals(that.actorsName) && actorsDOB.equals(that.actorsDOB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, charactersName, alias, mainAbility, actorsName, actorsDOB, age);
    }


    //toString

    @Override
    public String toString() {
        return "MarvelCharacter{" +
                "id=" + id +
                ", fullName='" + charactersName + '\'' +
                ", alias='" + alias + '\'' +
                ", mainAbility='" + mainAbility + '\'' +
                ", actorsName='" + actorsName + '\'' +
                ", ActorsDOB=" + actorsDOB +
                ", age=" + age +
                '}';
    }
}
