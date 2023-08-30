public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;

    private int precioMenores;
    private int precioMayores;


    public int obtenerPrecioPorEdad(int edad){
        return edad >= 18 ? precioMayores : precioMenores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;

        switch (id){
            case 1:
                precioMenores = 1300;
                precioMayores = 1500;
                break;
            case 2:
                precioMenores = 2000;
                precioMayores = 2300;
                break;
            case 3:
                precioMenores = -1;
                precioMayores = 2800;
                break;
        }

    }
}
