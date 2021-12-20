package es.acuesta.academy.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreateEstudianteException extends RuntimeException {
    
    public CreateEstudianteException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateEstudianteException(String message) {
		super(message);
	}
}


