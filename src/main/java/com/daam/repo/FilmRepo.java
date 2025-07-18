package com.daam.repo;

import com.daam.model.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepo extends CrudRepository<Film, Integer> {
}
