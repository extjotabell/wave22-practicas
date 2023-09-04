import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        Repositorio repoUno = new Repositorio();
        Cliente clienteUno = new Cliente("Javier","12345678");
        Reserva productoUno = new Reserva("Hotel",12456);

        ArrayList<Reserva> reservaUno = new ArrayList<>();

        reservaUno.add(productoUno);

        Localizador localizadorUno = new Localizador(clienteUno,reservaUno);

        ArrayList<Localizador> listaLocal = new ArrayList<>();

        listaLocal.add(localizadorUno);

        repoUno.setLocalizadores(listaLocal);





    }

    public static void aplicarDescuento(Localizador local){

        


    }


}
