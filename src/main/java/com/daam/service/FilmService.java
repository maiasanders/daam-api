package com.daam.service;

import com.daam.model.Film;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface FilmService {
    @GetMapping
    List<Film> findAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Film save(@RequestBody Film film);

    @GetMapping("/{id}")
    Film findById(@PathVariable int id);

    @PutMapping("/{id}")
    Film update(@PathVariable int id, @RequestBody Film film);

    void deleteById(int id);
}
