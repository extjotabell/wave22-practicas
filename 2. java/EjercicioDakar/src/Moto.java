public class Moto extends Vehiculo{
    public Moto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300, 2);
    }

    @Override
    public Integer getVelocidad() {
        return super.getVelocidad();
    }

    @Override
    public void setVelocidad(Integer velocidad) {
        super.setVelocidad(velocidad);
    }

    @Override
    public Integer getAceleracion() {
        return super.getAceleracion();
    }

    @Override
    public void setAceleracion(Integer aceleracion) {
        super.setAceleracion(aceleracion);
    }

    @Override
    public Double getAnguloDeGiro() {
        return super.getAnguloDeGiro();
    }

    @Override
    public void setAnguloDeGiro(Double anguloDeGiro) {
        super.setAnguloDeGiro(anguloDeGiro);
    }

    @Override
    public String getPatente() {
        return super.getPatente();
    }

    @Override
    public void setPatente(String patente) {
        super.setPatente(patente);
    }

    @Override
    public Integer getPeso() {
        return super.getPeso();
    }

    @Override
    public void setPeso(Integer peso) {
        super.setPeso(peso);
    }

    @Override
    public Integer getRuedas() {
        return super.getRuedas();
    }

    @Override
    public void setRuedas(Integer ruedas) {
        super.setRuedas(ruedas);
    }
}
