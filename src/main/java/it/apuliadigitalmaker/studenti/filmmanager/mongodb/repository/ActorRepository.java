package it.apuliadigitalmaker.studenti.filmmanager.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.model.Actor;
public interface ActorRepository extends MongoRepository<Actor, Long>{

}
