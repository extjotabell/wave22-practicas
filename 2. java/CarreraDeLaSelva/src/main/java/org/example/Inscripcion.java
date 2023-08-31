package org.example;

public class Inscripcion {
    private int id;
    private Categoria categoria;
    private Participante participante;
    private int precio;

    public Inscripcion(int id, Categoria categoria, Participante participante) {
        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setearPrecioInscripcion(){
        int edad = this.participante.getEdad();
        int idCategoria = this.categoria.getId();

        if(edad < 18){
            switch(idCategoria){
                case 1:
                    setPrecio(1300);
                    break;
                case 2:
                    setPrecio(2000);
                    break;
                case 3:
                    System.out.println("LOS MENORES NO SE PUEDEN INSCRIBIR A LA COSA AVANZADA");
                    break;
            }
        }
        else{
            switch(idCategoria){
                case 1:
                    setPrecio(1500);
                    break;
                case 2:
                    setPrecio(2300);
                    break;
                case 3:
                    setPrecio(2800);
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "Nombre: " +this.participante.getNombre()+ "\n" +
                "Categoria: " + this.categoria.getNombre()+ "\n" +
                "Precio: "+this.precio;
    }
}
