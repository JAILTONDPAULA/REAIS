package br.com.reais.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.reais.settings.Return;

@ControllerAdvice
public class ExceptionManager {
	@ExceptionHandler(NotFound.class)
	public ResponseEntity<Return<String>> notFound(NotFound nf){
		Return<String> ret = new Return<String>(false,nf.getMessage());
		return ResponseEntity.status(404).body(ret);
	}
}
