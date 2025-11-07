package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.model.errolResponeDTO;

import customException.FieldRequiredException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> hanleArithmeticException( ArithmeticException ex ,WebRequest request){
		errolResponeDTO ErrolResponeDTO = new errolResponeDTO() ; 
		ErrolResponeDTO.setErrol(ex.getMessage());
		List<String> details = new ArrayList<>() ; 
		details.add("Khong the chia het cho khong") ; 
		ErrolResponeDTO.setDetails(details);
		return new ResponseEntity<>(ErrolResponeDTO ,HttpStatus.INTERNAL_SERVER_ERROR ) ; 
	}
	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<Object> handleFieldRequairedException(FieldRequiredException ex , WebRequest request){
		errolResponeDTO ErrolResponeDTO = new errolResponeDTO() ; 
		ErrolResponeDTO.setErrol(ex.getMessage());
		List<String> details = new ArrayList<>() ; 
		details.add("Co du lieu truyen ve bi NULL , hoac rong") ; 
		ErrolResponeDTO.setDetails(details);
		return new  ResponseEntity<>(ErrolResponeDTO , HttpStatus.BAD_GATEWAY); 
	}
}
