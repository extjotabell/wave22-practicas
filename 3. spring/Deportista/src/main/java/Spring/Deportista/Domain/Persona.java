package Spring.Deportista.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;
}