package models;

import Interfaces.Comestible;

public abstract class Animal implements Comestible {
    public boolean herbivoro;
    public boolean carnivoro;

    public Animal(boolean herviboro, boolean carnivoro) {
        this.herbivoro = herviboro;
        this.carnivoro = carnivoro;
    }

    public boolean isHerviboro() {
        return herbivoro;
    }

    public void setHerviboro(boolean herviboro) {
        this.herbivoro = herviboro;
    }

    public boolean isCarnivoro() {
        return carnivoro;
    }

    public void setCarnivoro(boolean carnivoro) {
        this.carnivoro = carnivoro;
    }

    @Override
    public void comerHierba()
    {
        if (this.herbivoro)
        {
            System.out.println("Comiendo hierba, animal: " + this.getClass().getSimpleName());
        }
        else System.out.println(this.getClass().getSimpleName() + " no es herbivoro");
    }
    @Override
    public void comerCarne()
    {
        if(this.carnivoro)
        {
            System.out.println("Comiendo carne, animal: " + this.getClass().getSimpleName());
        }
        else System.out.println(this.getClass().getSimpleName() + " no es carnivoro");
    }
    @Override
    public void comerAnimal(Animal animal){
        if(this.carnivoro)
        {
            System.out.println(this.getClass().getSimpleName() + " comiendose al animal " + animal.getClass().getSimpleName());
        }
        else System.out.println(this.getClass().getSimpleName() + " no es carnivoro, no puede comerse a otro animal");
    }
}
