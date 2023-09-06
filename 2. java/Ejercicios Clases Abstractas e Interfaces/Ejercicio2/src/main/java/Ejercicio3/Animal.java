package Ejercicio3;

public abstract class Animal {
    public abstract void emitirSonido();
    public static void comer(Animal animal){
        if(animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }
        else if(animal instanceof Herbivoro){
            ((Herbivoro) animal).comerHierba();
        }
    }
}
