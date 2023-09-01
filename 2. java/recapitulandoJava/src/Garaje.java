import java.util.ArrayList;
import java.util.List;
public class Garaje {
    private double id;
    private List<Vehiculo> vehiculos;

    public Garaje(double id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
