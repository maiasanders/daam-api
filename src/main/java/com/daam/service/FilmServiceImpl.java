package com.daam.service;

import com.daam.model.Film;
import com.daam.repo.FilmRepo;
import com.daam.service.exception.NoRecordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepo repo;

    @Override
    public List<Film> findAll() {
        return (List<Film>) repo.findAll();
    }

    @Override
    public Film save(@RequestBody Film film) {
        return repo.save(film);
    }

    @Override
    public Film findById(@PathVariable int id) {
        Optional<Film> film = repo.findById(id);
        if (film.isPresent()) {
            return film.get();
        }
        throw new NoRecordException("Film with id " + id + " not found");
    }

    @Override
    public Film update(@PathVariable int id, @RequestBody Film film) {
        if (repo.findById(id).isPresent()) {
            return repo.save(film);
        }
        throw new NoRecordException("Film with id " + id + " not found");
    }

    @Override
    public void deleteById(int id) {
        if  (repo.findById(id).isPresent()) {
            repo.deleteById(id);
        } else  {
            throw new NoRecordException("Film with id " + id + " not found");
        }
    }
}
