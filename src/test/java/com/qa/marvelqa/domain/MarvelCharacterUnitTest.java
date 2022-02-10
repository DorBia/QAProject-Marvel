package com.qa.marvelqa.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarvelCharacterUnitTest {

    @Test
    public void testConstructorWithId(){
        MarvelCharacter hulk = new MarvelCharacter(1L, "Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22));

        assertEquals(1L, hulk.getId());
        assertEquals("Bruce Banner", hulk.getCharactersName());
        assertEquals("Hulk", hulk.getAlias());
        assertEquals("Regenerative Healing Factor", hulk.getMainAbility());
        assertEquals("Mark Rufallo", hulk.getActorsName());
        assertEquals(LocalDate.of(1967,11,22), hulk.getActorsDOB());
        assertEquals(54, hulk.getAge());
    }

    @Test
    public void testConstructorWithoutId(){
        MarvelCharacter hulk = new MarvelCharacter("Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22));

        assertEquals("Bruce Banner", hulk.getCharactersName());
        assertEquals("Hulk", hulk.getAlias());
        assertEquals("Regenerative Healing Factor", hulk.getMainAbility());
        assertEquals("Mark Rufallo", hulk.getActorsName());
        assertEquals(LocalDate.of(1967,11,22), hulk.getActorsDOB());
    }

    @Test
    public void testGettingAge(){
        MarvelCharacter hulk = new MarvelCharacter(1L, "Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22));

        assertEquals(54, hulk.getAge());

    }

    @Test
    public void testSetters(){
        MarvelCharacter deadpool = new MarvelCharacter();
        MarvelCharacter deadpooloutput = new MarvelCharacter(5L, "Wade Wilson", "Deadpool",
                "Regenerative Healing Factor", "Ryan Reynolds", LocalDate.of(1976,10,23), 45);

        deadpool.setId(5L);
        deadpool.setCharactersName("Wade Wilson");
        deadpool.setAlias("Deadpool");
        deadpool.setMainAbility("Regenerative Healing Factor");
        deadpool.setActorsName("Ryan Reynolds");
        deadpool.setActorsDOB(LocalDate.of(1976,10,23));
        deadpool.setAge(Period.between(LocalDate.of(1976,10,23), LocalDate.now()).getYears());

        assertEquals(deadpooloutput, deadpool);

    }

    @Test
    public void testToString(){
        MarvelCharacter deadpool = new MarvelCharacter(5L, "Wade Wilson", "Deadpool",
                "Regenerative Healing Factor", "Ryan Reynolds",
                LocalDate.of(1976,10,23), (Period.between(LocalDate.of(1976,10,23), LocalDate.now()).getYears()));

        assertEquals("MarvelCharacter{id=5, fullName='Wade Wilson', alias='Deadpool', mainAbility='Regenerative Healing Factor', actorsName='Ryan Reynolds', ActorsDOB=1976-10-23, age=45}", deadpool.toString());
    }

    @Test
    public void testHash(){
        MarvelCharacter deadpool = new MarvelCharacter(5L, "Wade Wilson", "Deadpool",
                "Regenerative Healing Factor", "Ryan Reynolds",
                LocalDate.of(1976,10,23), (Period.between(LocalDate.of(1976,10,23), LocalDate.now()).getYears()));
        MarvelCharacter deadpool2 = new MarvelCharacter(5L, "Wade Wilson", "Deadpool",
                "Regenerative Healing Factor", "Ryan Reynolds",
                LocalDate.of(1976,10,23), (Period.between(LocalDate.of(1976,10,23), LocalDate.now()).getYears()));

        assertEquals(deadpool.hashCode(), deadpool2.hashCode());
    }
}
