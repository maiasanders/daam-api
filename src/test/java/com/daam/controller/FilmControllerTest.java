package com.daam.controller;

import com.daam.model.Film;
import com.daam.service.FilmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@WebMvcTest(FilmController.class)
class FilmControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    FilmService service;


        Film expected = new Film(
            1,
            "Chunnel",
            "http://chunnelmovie.com",
            "Illuminating the darkest depths of international intrigue and personal sacrifice, 'Chunnel' takes you on a heart-pounding journey through the underbelly of the world's most vital tunnel. When a mysterious explosion rocks the Chunnel, trapping the U.S. President's daughter inside, the race against time begins. As rescuers tunnel their way through the wreckage, they unearth a web of conspiracies that threaten to reshape global politics. Unraveling the layers of deception becomes a gripping chess game, where every move could mean life or death. 'Chunnel' is not just a pulse-pounding thriller; it's a masterclass in suspense, leaving audiences at the edge of their seats, guessing until the final revelation. Get ready for a cinematic ride that will have you questioning alliances, unraveling secrets, and redefining the limits of human determination. The Chunnel holds more than just passengers; it harbors a tale of deception, bravery, and the resilience of the human spirit. Don't miss the tunnel of twists and turns that is 'Chunnel.'",
            "/images/posters/1.jpg",
            0,
            "There's a war 100 meters below the English Channel",
            7.1,
            "tt0137523",
            6.2,
            52
        );


    @Test
    void getFilmByIdReturnsFilm() throws Exception {
        when(service.findById(1)).thenReturn(expected);
        this.mockMvc.perform( get("/films/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

}
