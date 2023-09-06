package org.example;

import java.util.HashMap;

public class Category {
    private String tipoCategoria;
    private HashMap<String, Integer> cost = new HashMap<>();

    public Category(String tipoCategoria, HashMap<String, Integer> cost) {
        this.tipoCategoria = tipoCategoria;
        this.cost = cost;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public HashMap<String, Integer> getCost() {
        return cost;
    }

    public void setCost(HashMap<String, Integer> cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Category{" +
                "tipoCategoria='" + tipoCategoria + '\'' +
                ", cost=" + cost +
                '}';
    }
}
