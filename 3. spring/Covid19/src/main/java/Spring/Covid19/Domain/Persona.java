package Spring.Covid19.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona{
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private int codigoDeSintoma;
}