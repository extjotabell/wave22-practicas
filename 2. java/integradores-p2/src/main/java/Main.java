public class Main {
    public static void main(String[] args) {

        Cliente sancho = new Cliente("Sancho");

        Reserva paquete = new Reserva(1000, "Paquete completo", "Colombia", true);

        // primer requerimiento
        sancho.anadir_localizador();
        sancho.getUltimoLocalizador().anadir_reserva(paquete);
        double costo = sancho.calcular_total();

        System.out.println("Costo paquete completo: " + costo);

        // segundo requerimiento
        sancho.anadir_localizador();
        Reserva hotel_1 = new Reserva(250, "hotel", "Colombia");
        Reserva hotel_2 = new Reserva(250, "hotel", "Colombia");
        Reserva avion_1 = new Reserva(250, "avion", "Colombia");
        Reserva avion_2 = new Reserva(250, "avion", "Colombia");

        sancho.getUltimoLocalizador().anadir_reserva(hotel_1);
        sancho.getUltimoLocalizador().anadir_reserva(hotel_2);
        sancho.getUltimoLocalizador().anadir_reserva(avion_1);
        sancho.getUltimoLocalizador().anadir_reserva(avion_2);

        costo = sancho.calcular_total();

        System.out.println("Costo: " + costo);

        // Tercer requerimiento
        sancho.anadir_localizador();
        Reserva hotel = new Reserva(1000, "tour", "Mexico");
        sancho.getUltimoLocalizador().anadir_reserva(hotel);

        costo = sancho.calcular_total();

        System.out.println("Costo: " + costo);



    }
}