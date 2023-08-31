import java.util.*;

public class Categoria {

    public static List<Categoria> categorias = new ArrayList<>();
    private int id;
    private String nombre;
    private String descripcion;
    private double minorPrice;
    private double adultPrice;
    private boolean minorAllowed;
    private Set<Inscripcion> inscripcionList;

    public Categoria(int id, String nombre, String descripcion, double minorPrice, double adultPrice, boolean minorAllowed) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.minorPrice = minorPrice;
        this.adultPrice = adultPrice;
        this.minorAllowed = minorAllowed;
        this.inscripcionList = new HashSet<>();
        categorias.add(this);
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

    public double getMinorPrice() {
        return minorPrice;
    }

    public void setMinorPrice(double minorPrice) {
        this.minorPrice = minorPrice;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public boolean isMinorAllowed() {
        return minorAllowed;
    }

    public void setMinorAllowed(boolean minorAllowed) {
        this.minorAllowed = minorAllowed;
    }

    public Set<Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void setInscripcionList(Set<Inscripcion> inscripcionList) {
        this.inscripcionList = inscripcionList;
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        inscripcionList.add(inscripcion);
    }
    public void printInscripcions(){
        System.out.println("Lista de Participantes inscritos en la categoría " + nombre);
        System.out.println("|   Numero    |   Participante   |   Edad    |    Monto     |");

        for (Inscripcion inscrip : inscripcionList) {
            Participante participante = inscrip.getParticipante();
            if (inscrip.getCategoria().equals(this)) {
                System.out.println("     " + inscrip.getNumeroInscripcion() +"           " + participante.getNombre()+" "+ participante.getApellido()+"       " + participante.getEdad() + "        " + inscrip.getMonto());
            }
        }
    }

    public void eliminarParticipante(Participante participante, Categoria categoria) {
        List<Inscripcion> inscripcionesParticipante = participante.getInscripciones();

        for (Inscripcion inscripcion : inscripcionesParticipante) {
            if (inscripcion.getCategoria().equals(categoria)) {
                participante.removerInscripcion(inscripcion);
                categoria.removerInscripcion(inscripcion);
                System.out.println("Participante eliminado de la categoría");
                this.printInscripcions();
                return;
            }
        }

        System.out.println("El Participante no está registrado en esta categoría");
    }

    public void eliminarParticipanteDeTodasCategorias(Participante participante) {
        List<Inscripcion> inscripcionesParticipante = participante.getInscripciones();

        for (Inscripcion inscripcion : inscripcionesParticipante) {
            Categoria categoria = inscripcion.getCategoria();
            participante.removerInscripcion(inscripcion);
            categoria.removerInscripcion(inscripcion);
        }

        System.out.println("Participante eliminado de todas las categorías");
        this.printInscripcions();
    }
    public void removerInscripcion(Inscripcion inscripcion) {
        inscripcionList.remove(inscripcion);
    }

}
