package domain;

public class Curriculum implements Documento{
    private Persona persona;

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                '}';
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
