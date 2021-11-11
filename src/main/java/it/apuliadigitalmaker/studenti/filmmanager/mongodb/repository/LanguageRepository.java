package it.apuliadigitalmaker.studenti.filmmanager.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.model.Language;

public interface LanguageRepository extends MongoRepository<Language, Long>{

public List<Language> findByName(String name);
	
	public List<Language> findByNameLikeIgnoreCase(String name);
}
