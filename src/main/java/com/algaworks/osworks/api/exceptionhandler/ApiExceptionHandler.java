package com.algaworks.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.osworks.api.exceptionhandler.Problema.Campo;
import com.algaworks.osworks.domain.exception.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Problema problema = new Problema();
		problema.setStatus(status.value());
		problema.setTitulo(ex.getMessage());
		problema.setDataHora(OffsetDateTime.now());
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		List<Problema.Campo> campos = new ArrayList<Problema.Campo>();
		for(ObjectError error: ex.getBindingResult().getAllErrors()) {
			String mensagem = error.getDefaultMessage();
			String nome = error.getObjectName();
			campos.add(new Problema.Campo(nome, mensagem));
		}
		
		Problema problema = new Problema();
		problema.setStatus(status.value());
		problema.setTitulo("Um ou mais campos preenchidos incorretamente. Preencha-os corretamente e tente novamente");
		problema.setDataHora(OffsetDateTime.now());
		problema.setCampos(campos);
		
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}

}
