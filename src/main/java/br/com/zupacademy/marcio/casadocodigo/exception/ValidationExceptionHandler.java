package br.com.zupacademy.marcio.casadocodigo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {
	
	@ExceptionHandler
	@ResponseBody
	public String handleInvalidFieldException(InvalidFieldException exception) {
		return exception.getMessage();
	}
}
