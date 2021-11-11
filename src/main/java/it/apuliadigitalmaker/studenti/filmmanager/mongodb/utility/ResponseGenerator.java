package it.apuliadigitalmaker.studenti.filmmanager.mongodb.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.common.CommonResponseCode;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto.BaseResponseBody;

public class ResponseGenerator {
	
	public static <T> ResponseEntity<?> generateResponse(T payload, CommonResponseCode respCode, boolean success, HttpStatus httpStatus){
		
		return new ResponseEntity<>(
				new BaseResponseBody<>(success, respCode.getMessage(), respCode.getResponseCode(), payload),
				httpStatus
		);
		
	}

}
