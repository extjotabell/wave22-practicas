import java.util.ArrayList;
public class Cliente {
    ArrayList<Localizador> localizadores = new ArrayList<>();
    int cant_localizadores = 0;
    String nombre;

    double descuento_futuro;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public void anadir_localizador(){
        Localizador localizador = new Localizador(this.nombre);
        this.localizadores.add(localizador);
        this.cant_localizadores+=1;
    }

    public Localizador getUltimoLocalizador(){
        return this.localizadores.get(cant_localizadores - 1);
    }

    public int getCant_localizadores() {
        return cant_localizadores;
    }

    public double calcular_total(){
        double descuento = 1;

        if (this.descuento_futuro == 0.05){
            descuento = 0.95;
            this.descuento_futuro = 1;
        }

        if (this.cant_localizadores >= 2){
            this.descuento_futuro = 0.05;
        }

        // obtener último localizador
        Localizador localizador = this.localizadores.get(cant_localizadores - 1);

        for (Reserva reserva : localizador.getReservas()){
            if (reserva.paquete_completo){
               descuento-=0.10;
               break;
            }
        }

        // descuento 2 revervas hotel y 2 boletos de viaje
        if (localizador.getCantidad_reservas() >= 2) {
            int cant_hotel = 0;
            int cant_avion = 0;

            // Revisar si hay 2 reservas de hotel o avion
            for ( Reserva reserva : localizador.getReservas()){
                if ( reserva.getTipo() == "hotel") {
                    cant_hotel+=1;
                }
                if ( reserva.getTipo() == "avion") {
                    cant_avion+=1;
                }
            }

            // añadir caso multiplos de dos más adelante
            if (cant_hotel >= 2 ) {
                for ( Reserva reserva : localizador.getReservas()){
                    if ( reserva.getTipo() == "hotel") {
                        reserva.costo = reserva.costo*0.95;
                    }

                }
            }

            if (cant_avion >= 2 ) {
                for ( Reserva reserva : localizador.getReservas()){
                    if ( reserva.getTipo() == "avion") {
                        reserva.setCosto(reserva.getCosto()*0.95);
                    }
                }
            }

        }
        double total = 0;
        for (Reserva reserva : localizador.getReservas()){
            total += reserva.getCosto();
        }

        total = total * descuento;

        return total;
    }
}
