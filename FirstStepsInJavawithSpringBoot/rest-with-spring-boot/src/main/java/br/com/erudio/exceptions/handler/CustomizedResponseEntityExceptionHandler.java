package br.com.erudio.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.erudio.exceptions.ExceptionResponse;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

@ControllerAdvice //Concentração de tratamento de erro, ou seja, um tratamento global de erros dentro da aplicação
@RestController	  //Annotation que define que a classe é um controller
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	//Tratando todas as exceções
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
		
		//Tratamento da exceção  pelo JSON
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
																	ex.getMessage(),
																	request.getDescription(false));
		//retorna o status code generico
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//Tratando todas as exceções
	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request)
	{
		//Tratamento da exceção  pelo JSON
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
																	ex.getMessage(),
																	request.getDescription(false));
		
		//Retorna um status code 400
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
}
