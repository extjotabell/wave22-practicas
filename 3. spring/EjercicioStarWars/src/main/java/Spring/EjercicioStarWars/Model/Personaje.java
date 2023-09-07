package Spring.EjercicioStarWars.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {
    private String name;
    private int height;
    private int mass;
    private String hairColor;
    private String skinColor;
    private String birthYear;
    private String gender;
    private String homeWorld;
    private String species;
}
