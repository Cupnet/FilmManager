package it.apuliadigitalmaker.studenti.filmmanager.mongodb.service;

import java.util.List;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.requestDto.FilmRequestDto;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto.FilmResponseDto;

public interface FilmService {

	public List<FilmResponseDto> getFilms();
	
	public FilmResponseDto getFilm(Long filmId);
	
	public FilmResponseDto createFilm(FilmRequestDto film);
	
	public FilmResponseDto updateFilm(Long filmId, FilmRequestDto film);
	
	public boolean deleteFilm(Long filmId);
	
}
