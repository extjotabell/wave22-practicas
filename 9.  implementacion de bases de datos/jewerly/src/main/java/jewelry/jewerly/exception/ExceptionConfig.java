package jewelry.jewerly.exception;

import jewelry.jewerly.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(IdNotExistsException.class)
    public ResponseEntity<MessageDto> idNotExistsException(IdNotExistsException e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

}