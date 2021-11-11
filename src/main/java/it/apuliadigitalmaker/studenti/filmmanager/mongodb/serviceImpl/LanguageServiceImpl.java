package it.apuliadigitalmaker.studenti.filmmanager.mongodb.serviceImpl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.model.Language;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.repository.LanguageRepository;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.requestDto.LanguageRequestDto;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto.LanguageResponseDto;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService{

	@Autowired
	LanguageRepository languageRepo;
	
	@Autowired
	LanguageConverter languageConverter;
	
	@Override
	public List<LanguageResponseDto> findLanguages(String name) {
		
		if (name == null || name.isBlank()) {
			return languageConverter.convertToDtoList(languageRepo.findAll());
		} else {
			return languageConverter.convertToDtoList(languageRepo.findByNameLikeIgnoreCase(name));
		}
		
	}

	@Override
	public LanguageResponseDto findLanguageById(Long id) {
		Optional<Language> categoryOpt = languageRepo.findById(id);
		if (categoryOpt.isPresent()) {
			return languageConverter.convertToDto(categoryOpt.get());
		} else {
			return null;
		}
	}

	@Override
	public LanguageResponseDto createLanguage(LanguageRequestDto languageRequest) {
		Language language = languageConverter.convertToEntity(languageRequest);
		language = languageRepo.save(language);
		return languageConverter.convertToDto(language);
	}

	@Override
	public LanguageResponseDto updateLanguage(LanguageRequestDto languageRequest, Long languageId) {
		Optional<Language> languageOpt = languageRepo.findById(languageId);
		Language language;
		if (languageOpt.isEmpty()) {
			throw new IllegalArgumentException();
		} else {
			language = languageOpt.get();
		}
		language = languageConverter.convertToEntity(languageRequest);
		language.setLanguageId(languageId);
		language = languageRepo.save(language);
		return languageConverter.convertToDto(language);
	}

	@Override
	public boolean deleteLanguage(Long id) {
		languageRepo.deleteById(id);
		return languageRepo.findById(id).isEmpty();
	}
	
	

}
