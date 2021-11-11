package it.apuliadigitalmaker.studenti.filmmanager.mongodb.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.repository.FilmRepository;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.requestDto.FilmRequestDto;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto.FilmResponseDto;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {
	
	@Autowired
	FilmRepository filmRepository;

	@Override
	public List<FilmResponseDto> getFilms() {
		
		filmRepository.findAll();
		
		return null;
	}

	@Override
	public FilmResponseDto getFilm(Long filmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilmResponseDto createFilm(FilmRequestDto film) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilmResponseDto updateFilm(Long filmId, FilmRequestDto film) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteFilm(Long filmId) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
