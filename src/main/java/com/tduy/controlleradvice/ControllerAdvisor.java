package com.tduy.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tduy.customerexception.FielRequiredException;
import com.tduy.model.ErrorExceptionDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(FielRequiredException.class)
	public ResponseEntity<Object> handlerFielRequiredException(FielRequiredException ex, WebRequest request) {
		ErrorExceptionDTO errorExceptionDTO = new ErrorExceptionDTO();
		errorExceptionDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("Check params and code are correct?");
		errorExceptionDTO.setDetails(details);
		return new ResponseEntity<Object>(errorExceptionDTO, HttpStatus.BAD_GATEWAY);
	}
}
