package bootcamp.socialMeli.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message)
    {
        super(message);
    }
}
