public class Mac implements Computadora{
    public int nucleos = 3;

    public Mac(int nucleos) {
        this.nucleos = nucleos;
    }

    public void arrancar(){
        System.out.println("Prendiendo pc");
    }

    @Override
    public String arrancar(String prefix, String suffix) {
        return "Tutututu";
    }
}