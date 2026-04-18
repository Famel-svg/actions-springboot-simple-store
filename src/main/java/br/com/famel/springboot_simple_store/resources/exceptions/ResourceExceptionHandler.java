package br.com.famel.springboot_simple_store.resources.exceptions;
import br.com.famel.springboot_simple_store.service.exceptions.DatabaseException;
import br.com.famel.springboot_simple_store.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new StandardError(Instant.now(), status.value(), "Resource not found", e.getMessage(), request.getRequestURI()));
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseNotFound(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(new StandardError(Instant.now(), status.value(), "Database error", e.getMessage(), request.getRequestURI()));
    }
}
