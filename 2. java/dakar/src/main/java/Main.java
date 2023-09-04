public class Main {
    public static void main(String[] args) {

        Carrera autosLocos = new Carrera(300, 300, "Autos locos");

        autosLocos.darDeAltaAuto(100, 99, 0.35, "5A");
        autosLocos.darDeAltaMoto(130, 80, 0.50, "6A");

        autosLocos.darDeAltaSocorristaAuto(60, 80, 0.6, "help", 1100, 4);
        autosLocos.darDeAltaSocorristaMoto(90, 90, 0.4, "help-sa", 500, 2);

        Vehiculo ganador = autosLocos.encontrarGanador();
        System.out.println(ganador);

        Vehiculo vehiculo = autosLocos.getVehiculos().get(0);
        SocorristaAuto socorrista = (SocorristaAuto) autosLocos.getSocorristas().get(0);
        socorrista.socorrer((Auto) vehiculo);

    }
}