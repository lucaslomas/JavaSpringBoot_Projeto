package lucas.com.developer.web.resource.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lucas.com.developer.web.service.exceptions.DataBaseException;
import lucas.com.developer.web.service.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNtoFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getServletPath());
        return ResponseEntity.status(status).body(standardError);
    }
    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataIntegrityViolation(DataBaseException e, HttpServletRequest request){
        String error = "Data base error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getServletPath());
        return ResponseEntity.status(status).body(standardError);
    }

}
