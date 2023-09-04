import domain.Cliente;
import domain.Localizador;
import domain.Paquete;
import domain.Reserva;
import repository.impl.ClienteRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------SE CREAN USUARIOS---------------");
        Cliente clienteMartin = new Cliente(1, "Martin", "Martinez",
                "martin@digitalhouse.com");

        Cliente clienteJulio = new Cliente(2, "Julio", "Alvarez",
        "juliojoel.alvarez@mercadolibre.com");

        System.out.println("---------------SE CREAN LOCALIZADORES----------------");
        Localizador localizador = new Localizador();
        Localizador localizadorJulio = new Localizador();

        System.out.println("--------------SE CREAN Y SETEAN PAQUETES A USUARIOS----------------");
        Paquete paquete = new Paquete();
        clienteMartin.setPaquete(paquete);

        Paquete paqueteJulio = new Paquete();
        clienteJulio.setPaquete(paqueteJulio);

        System.out.println("------------SE CREAN RESERVAS Y SETEAN LAS MISMAS A UN PAQUETE------");

        Reserva reserva = new Reserva(clienteMartin, "Sheraton",
                "Hamburguesa", 1, "Avion");
        Reserva reserva2 = new Reserva(clienteMartin, "Hotel pepito", "Milanesa",
                2, "Barco");
        paquete.addReserva(reserva);
        paquete.addReserva(reserva2);

        Reserva reservaJulio = new Reserva(clienteJulio, "empire state",
                "fideos con tuco", 2, "Auto");
        paqueteJulio.addReserva(reservaJulio);

        System.out.println("--------------SE AÑADEN PAQUETES A LOCALIZADORES");

        localizador.addPaquete(paquete);
        localizadorJulio.addPaquete(paqueteJulio);

        System.out.println("---------------IMPRIMIENDO PAQUETES--------------");
        System.out.println(paquete);
        System.out.println(paqueteJulio);

        ClienteRepositoryImpl clienteRepository = new ClienteRepositoryImpl();

    }
}
