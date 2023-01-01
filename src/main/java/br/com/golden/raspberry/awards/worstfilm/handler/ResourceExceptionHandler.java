package br.com.golden.raspberry.awards.worstfilm.handler;

import br.com.golden.raspberry.awards.worstfilm.dto.DetailErrorHttp;
import br.com.golden.raspberry.awards.worstfilm.exception.NoSuchFileCSVException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(NoSuchFileCSVException.class)
    public ResponseEntity<DetailErrorHttp> NoSuchFileCSVExceptionException(NoSuchFileCSVException ex, HttpServletRequest request){
        final DetailErrorHttp error = new DetailErrorHttp();
        error.setError("400");
        error.setErrorTitle(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
