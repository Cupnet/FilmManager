package it.apuliadigitalmaker.studenti.filmmanager.mongodb.service;




import java.util.List;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.requestDto.LanguageRequestDto;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto.LanguageResponseDto;

public interface LanguageService {
	
	public List<LanguageResponseDto> findLanguages(String name) ;
	
	public LanguageResponseDto findLanguageById(Long id);
	
	public LanguageResponseDto createLanguage(LanguageRequestDto languageRequest);
	
	public LanguageResponseDto updateLanguage(LanguageRequestDto languageRequest, Long languageId);
	
	public boolean deleteLanguage(Long id);

}
