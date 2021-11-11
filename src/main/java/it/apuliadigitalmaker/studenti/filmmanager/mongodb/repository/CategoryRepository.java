package it.apuliadigitalmaker.studenti.filmmanager.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.model.Category;

public interface CategoryRepository extends MongoRepository<Category, Long> {
	
	public List<Category> findByName(String name);
	
	public List<Category> findByNameLikeIgnoreCase(String name);

}
