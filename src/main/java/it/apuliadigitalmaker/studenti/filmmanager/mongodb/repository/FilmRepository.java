package it.apuliadigitalmaker.studenti.filmmanager.mongodb.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.model.Film;

public interface FilmRepository extends MongoRepository<Film, Long>{

}
