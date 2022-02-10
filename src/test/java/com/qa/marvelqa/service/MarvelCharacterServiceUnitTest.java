package com.qa.marvelqa.service;

import com.qa.marvelqa.domain.MarvelCharacter;
import com.qa.marvelqa.repo.CharacterRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class MarvelCharacterServiceUnitTest {

    @InjectMocks
    private MarvelCharacterService service;

    @Mock
    private CharacterRepo repo;


    @Test
    public void createTest(){
        MarvelCharacter input = new MarvelCharacter("Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22));
        MarvelCharacter output = new MarvelCharacter(1L, "Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22));

        Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);

        assertEquals(output, this.service.create(input));

        Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
    }

    @Test
    public void getAllTest(){
        List<MarvelCharacter> output = new ArrayList<>();
        output.add(new MarvelCharacter("Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22)));

        Mockito.when(this.repo.findAll()).thenReturn(output);

        assertEquals(output, this.service.getAll());

        Mockito.verify(this.repo, Mockito.times(1)).findAll();
    }

    @Test
    public void getByIdTest(){
        Long id = 1L;
        MarvelCharacter outcome = new MarvelCharacter(id, "Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22));

        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(outcome));

        assertEquals(outcome, this.service.getById(id));

        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
    }

    @Test
    public void getByAbility(){
        String mainAbility = "Regenerative Healing Factor";
        List<MarvelCharacter> output = new ArrayList<>();
        output.add(new MarvelCharacter("Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22)));

        Mockito.when(this.repo.findByAbility(mainAbility)).thenReturn(Optional.of(output));

        assertEquals(output, this.service.getByAbility(mainAbility));

        Mockito.verify(this.repo, Mockito.times(1)).findByAbility(mainAbility);
    }

    @Test
    public void getUpdate() {
        Long id = 1L;
        MarvelCharacter toUpdate = new MarvelCharacter("Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22));
        Optional<MarvelCharacter> output = Optional.of(new MarvelCharacter(id, null, null, null, null, null));
        MarvelCharacter updated = new MarvelCharacter(id, toUpdate.getCharactersName(), toUpdate.getAlias(), toUpdate.getMainAbility(),
                toUpdate.getActorsName(), toUpdate.getActorsDOB());

        Mockito.when(this.repo.findById(id)).thenReturn(output);
        Mockito.when(this.repo.saveAndFlush(updated)).thenReturn(updated);

        assertEquals(updated, this.service.update(id, toUpdate));

        Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(updated);
        Mockito.verify(this.repo, Mockito.times(1)).findById(id);

    }

    @Test
    public void deleteTest(){
        Long id = 1L;

        Mockito.when(this.repo.existsById(id)).thenReturn(true);

        assertFalse(this.service.delete(id));

        Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
    }

}
