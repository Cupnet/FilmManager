package it.apuliadigitalmaker.studenti.filmmanager.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.model.Language;

public interface LanguageRepository extends MongoRepository<Language, Long>{

}
