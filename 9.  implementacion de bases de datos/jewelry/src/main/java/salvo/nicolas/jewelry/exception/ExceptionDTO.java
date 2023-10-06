package salvo.nicolas.jewelry.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class ExceptionDTO {
    private String message;
    public ExceptionDTO(String message) {
        this.message = message;
    }
}
