package com.daam.controller;

import com.daam.model.Film;
import com.daam.service.FilmService;
import com.daam.service.exception.NoRecordException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/films")
@AllArgsConstructor
public class FilmController {

    private FilmService service;

    @GetMapping
    public List<Film> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Film save(@RequestBody Film film) {
        return service.save(film);
    }

    @GetMapping("/{id}")
    public Film findById(@PathVariable int id) {
        try {
            return service.findById(id);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public Film update(@PathVariable int id, @RequestBody Film film) {
        try {
            return service.update(id, film);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        try {
            service.deleteById(id);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
