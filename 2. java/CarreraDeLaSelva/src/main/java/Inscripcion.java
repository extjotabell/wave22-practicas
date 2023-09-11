public class Inscripcion {
    int nroInscripcion;
    Categoria categoria;
    Participante participante;
    float costo;

    public Inscripcion(int nroInscripcion, Categoria categoria, Participante participante){
        this.nroInscripcion = nroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        if(categoria.id == 1){
            if(participante.edad > 18){
                costo = 1300;
            }else{
                costo = 1500;
            }
        }
        else if(categoria.id == 2){
            if(participante.edad > 18){
                costo = 2000;
            }else{
                costo = 2300;
            }
        }
        else if (categoria.id == 3){
            if(participante.edad > 18){
                throw new RuntimeException("Los participantes menores de edad no pueden participar en esta categoria");
            }else{
                costo = 2800;
            }
        }
    }
}
