package it.apuliadigitalmaker.studenti.filmmanager.mongodb.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.common.CommonResponseCode;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.requestDto.FilmRequestDto;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto.FilmResponseDto;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.service.FilmService;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.utility.ResponseGenerator;

@RestController
@RequestMapping("/Films")
public class FilmController {
	
	@Autowired
	FilmService filmService;
	
	@GetMapping
	public ResponseEntity<?> getFilms() {
		
		List<FilmResponseDto> films = filmService.getFilms();
		if (films == null || films.isEmpty()) {
			return ResponseGenerator.generateResponse(null, CommonResponseCode.NOT_FOUND, false, HttpStatus.NOT_FOUND);
		} else {
			return ResponseGenerator.generateResponse(films, CommonResponseCode.OK, true, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{filmId}")
	public ResponseEntity<?> geFilm(@PathVariable(name="filmId", required=true) Long filmId) {
		
		FilmResponseDto film = filmService.getFilm(filmId);
		if(film == null) {
			return ResponseGenerator.generateResponse(null, CommonResponseCode.NOT_FOUND, false, HttpStatus.NOT_FOUND);
		} else {
			return ResponseGenerator.generateResponse(film, CommonResponseCode.OK, true, HttpStatus.OK);
		}
	}
	
	@PutMapping("/{filmId}")
	public ResponseEntity<?> updateFilm(@PathVariable(name="filmId", required=true) Long filmId, 
			@RequestBody(required = true) @Valid FilmRequestDto filmReq) {
		
		FilmResponseDto film;
		try {
			film = filmService.updateFilm(filmId, filmReq);
		} catch (IllegalArgumentException e) {
			return ResponseGenerator.generateResponse(null, CommonResponseCode.NOT_FOUND, false, HttpStatus.NOT_FOUND);
		}
		return ResponseGenerator.generateResponse(film, CommonResponseCode.OK, true, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createFilm(@RequestBody(required = true) @Valid FilmRequestDto filmReq){
		
		FilmResponseDto film = filmService.createFilm(filmReq);
		return ResponseGenerator.generateResponse(film, CommonResponseCode.OK, true, HttpStatus.OK);

	}
	
	@DeleteMapping("/{filmId}")
	public ResponseEntity<?> deleteFilm(@PathVariable(name="filmId") Long filmId){
		
		if(filmService.deleteFilm(filmId)) {
			return ResponseGenerator.generateResponse(null, CommonResponseCode.OK, true, HttpStatus.OK);
		} else {
			return ResponseGenerator.generateResponse(null, CommonResponseCode.UNEXPECTED_ERROR, false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
			
	}

}
