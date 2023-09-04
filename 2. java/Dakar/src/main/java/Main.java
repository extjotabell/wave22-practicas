import models.Auto;
import models.Carrera;

public class Main {

    public static void main(String[] args) {

        Carrera carreraCopaPiston = new Carrera(1000, 10, "Copa Piston", 3);

        carreraCopaPiston.darDeAltaAuto(100, 20, 30, "AAA");
        carreraCopaPiston.darDeAltaAuto(150, 40, 60, "AAB");
        carreraCopaPiston.darDeAltaMoto(80, 5, 3, "AAC");

        System.out.println(carreraCopaPiston.definirGanador());

    }

}
