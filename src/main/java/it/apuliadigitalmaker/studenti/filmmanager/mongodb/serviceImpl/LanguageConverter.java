package it.apuliadigitalmaker.studenti.filmmanager.mongodb.serviceImpl;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.requestDto.LanguageRequestDto;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto.LanguageResponseDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.model.Language;

@Component
//@Scope("prototype")
public class LanguageConverter {

	public Language convertToEntity(LanguageRequestDto languageRequest) {
		
		return new Language(null, languageRequest.getName());
	}
	
	public LanguageResponseDto convertToDto(Language language) {
		
		return new LanguageResponseDto(language.getName(), language.getLanguageId());
	}
	
	public List<LanguageResponseDto> convertToDtoList(List<Language> languageList) {
		
		return languageList.stream().map(c -> convertToDto(c)).collect(Collectors.toList());
		
	}
	
}
