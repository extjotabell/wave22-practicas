public class Auto extends VehiculoClase implements Vehiculo{

    @Override
    public void acelerar(){
        System.out.println(Vehiculo.velocidad);
        System.out.println("Ñooooouuuuun");
    }

    @Override
    public void cambiarMarcha(){
        System.out.println("Cambiando marcha bubu");
    }
}
