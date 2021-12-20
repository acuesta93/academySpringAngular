package es.acuesta.academy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreateAsignaturaException extends RuntimeException {

    public CreateAsignaturaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateAsignaturaException(String message) {
		super(message);
	}
    
}