public class Gato extends Animal{
    private String nombre;

    public Gato(String especie, String nombre) {
        super(especie);
        this.nombre = nombre;
    }

    public void miau() {
        System.out.println("Miau");
    }

    @Override
    public String toString() {
        return super.toString() + "Gato{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
