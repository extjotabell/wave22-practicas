public abstract class  Documento implements Imprimible{

    //Una clase abstracta al menos debe contener un método abstracto.
    public abstract void imprimir();

    @Override
    public void imprimirTipoDoc(){
        System.out.println("----------- " + getClass().getSimpleName().toUpperCase() + " ------------");
    }

}
