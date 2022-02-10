package com.qa.marvelqa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.marvelqa.domain.MarvelCharacter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = {"classpath:character-schema.sql", "classpath:character-data.sql"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CharacterControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper map;


    @Test
    public void createTest() throws Exception {
        MarvelCharacter request = new MarvelCharacter("Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22));
        MarvelCharacter result = new MarvelCharacter(2L, "Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22));

        String requestAsJSON = this.map.writeValueAsString(request);
        String resultAsJSON = this.map.writeValueAsString(result);

        mock.perform(post("/marvel-char/create").contentType(MediaType.APPLICATION_JSON).content(requestAsJSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(resultAsJSON));
    }

    @Test
    public void getAllTest() throws Exception {
        List<MarvelCharacter> output = new ArrayList<>();
        output.add(new MarvelCharacter(1L,"Loki Laufeyson", "Loki",
                "Illusion Manipulation", "Tom Hiddleston",
                LocalDate.of(1981,2,9)));
        String outputAsJSON = this.map.writeValueAsString(output);

        mock.perform(get("/marvel-char/getAll").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound()).andExpect(content().json(outputAsJSON));
    }

    @Test
    public void getByIdTest() throws Exception {
        MarvelCharacter output = new MarvelCharacter(1L,"Loki Laufeyson", "Loki",
                "Illusion Manipulation", "Tom Hiddleston",
                LocalDate.of(1981,2,9));

        String outputAsJSON = this.map.writeValueAsString(output);

        mock.perform(get("/marvel-char/get/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andExpect(content().json(outputAsJSON));
    }

    @Test
    public void getByAbilityTest() throws  Exception {
        List<MarvelCharacter> output = new ArrayList<>();
        output.add(new MarvelCharacter(1L,"Loki Laufeyson", "Loki",
                "Illusion Manipulation", "Tom Hiddleston",
                LocalDate.of(1981,2,9)));

        String outputAsJSON = this.map.writeValueAsString(output);

        mock.perform(get("/marvel-char/get?mainAbility=Illusion Manipulation").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound()).andExpect(content().json(outputAsJSON));
    }

    @Test
    public void updateTest() throws Exception {
        MarvelCharacter input = new MarvelCharacter("Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22));
        MarvelCharacter output = new MarvelCharacter(1L, "Bruce Banner", "Hulk",
                "Regenerative Healing Factor", "Mark Rufallo",
                LocalDate.of(1967,11,22));

        String inputAsJSON = this.map.writeValueAsString(input);
        String outputAsJSON = this.map.writeValueAsString(output);

        mock.perform(put("/marvel-char/update/1").contentType(MediaType.APPLICATION_JSON).content(inputAsJSON))
                .andExpect(status().isAccepted()).andExpect(content().json(outputAsJSON));
    }

    @Test
    public void deleteTest() throws Exception {
        mock.perform(delete("/marvel-char/delete/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
    }
}
