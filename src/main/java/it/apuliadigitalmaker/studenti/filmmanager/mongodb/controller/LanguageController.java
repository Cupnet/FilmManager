package it.apuliadigitalmaker.studenti.filmmanager.mongodb.controller;


	import java.util.List;

	//import org.springframework.data.annotation.Id;
	//import org.springframework.data.mongodb.core.mapping.Document;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.dao.EmptyResultDataAccessException;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

	import it.apuliadigitalmaker.studenti.filmmanager.mongodb.common.CommonResponseCode;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.requestDto.LanguageRequestDto;
//import it.apuliadigitalmaker.dev2022.filmmanager.responseDto.BaseResponseBody.BaseResponseBodyBuilder;
	import it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto.BaseResponseBody;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto.LanguageResponseDto;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.service.LanguageService;

	@RestController
	@RequestMapping("/languages")
	public class LanguageController {
		
		@Autowired
		LanguageService languageService;
		
		@GetMapping
		public ResponseEntity<?> getLanguage(@RequestParam(required = false) String name) {
		
			List<LanguageResponseDto> result = languageService.findLanguages(name);
			if (result.isEmpty()) {
				return createNotFoundResponse();
			} else {
				return createSuccessResponse(result);
			}
			
		}
		
		@GetMapping("/{categoryId}")
		public ResponseEntity<?> getLanguageById(@PathVariable(name="LanguageId", required=true) Long languageId) {

			LanguageResponseDto result = languageService.findLanguageById(languageId);
			if (result == null) {
				return createNotFoundResponse();
			} else {
				return createSuccessResponse(result);
			}

		}
		
		@PostMapping
		public ResponseEntity<?> createLanguage(@RequestBody(required = true) LanguageRequestDto languageDto) {
			return createSuccessResponse(languageService.createLanguage(languageDto));
		}
		
		@PutMapping("/{languageId}")
		public ResponseEntity<?> updateLanguage(@RequestBody LanguageRequestDto languageDto, 
				@PathVariable("categoryId") Long languageId) {
			LanguageResponseDto languageResponse;
			try {
				languageResponse = languageService.updateLanguage(languageDto, languageId);
			} catch (IllegalArgumentException e) {
				return createNotFoundResponse();
			}
			return createSuccessResponse(languageResponse);
		}
		
		@DeleteMapping("/{languageId}")
		public ResponseEntity<?> deleteLanguage(@PathVariable("languageId") Long languageId) {
			try {
				languageService.deleteLanguage(languageId);
			} catch(EmptyResultDataAccessException e) {
				return createNotFoundResponse();
			}
				return createSuccessResponse(null);
		}
		
	/*	private BaseResponseBody<Object> getEmptyResponse() {
			return new BaseResponseBody<>(false, CommonResponseCode.NOT_FOUND.getMessage(), CommonResponseCode.NOT_FOUND.getResponseCode(), null);
		}
		
		private <T> BaseResponseBody<T> getDataResponse(T data) {
			return new BaseResponseBody<>(true, CommonResponseCode.OK.getMessage(), CommonResponseCode.OK.getResponseCode(), data);
		}*/
		
		private ResponseEntity<?> createNotFoundResponse() {
			return new ResponseEntity<>(
					BaseResponseBody.builder().message(CommonResponseCode.NOT_FOUND.getMessage())
					.responseCode(CommonResponseCode.NOT_FOUND.getResponseCode())
					.success(false).build(), HttpStatus.NOT_FOUND);
		}

		private <T> ResponseEntity<?> createSuccessResponse(T payload) {
			return new ResponseEntity<>(
					BaseResponseBody.builder()
					.message(CommonResponseCode.OK.getMessage())
					.responseCode(CommonResponseCode.OK.getResponseCode())
					.success(true)
					.data(payload)
					.build(), HttpStatus.OK);
		}

	}

