import java.util.ArrayList;
import java.util.List;

public class Categoria {
    int id;
    String name;
    String description;
    List<Participante> enrrolled = new ArrayList<>();
    int money;

    public Categoria(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int get_price(Participante participante){
        if(this.id == 1){
            if(participante.age < 18){
                return 1300;
            }
            else{
                return 1500;
            }
        }
        else if(this.id == 2){
            if(participante.age < 18){
                return 2000;
            }
            else{
                return 2300;
            }
        }
        else{
            return 2800;
        }
    }
}
