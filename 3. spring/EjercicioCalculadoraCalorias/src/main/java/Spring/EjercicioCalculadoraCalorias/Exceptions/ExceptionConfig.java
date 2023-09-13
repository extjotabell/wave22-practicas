package Spring.EjercicioCalculadoraCalorias.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {
    @ExceptionHandler(PlatoNotFoundException.class)
    public ResponseEntity<?> PlatoNotFoundException(Exception e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(InvalidPropException.class)
    public ResponseEntity<?> InvalidPropException(Exception e)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
