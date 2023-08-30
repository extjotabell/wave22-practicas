package domain;

import java.util.ArrayList;

public class Competencia {
    private ArrayList<Categoria> categorias;

    public Categoria getCategoria(int id) {
        Categoria categoriaSeleccionada = new Categoria();
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                categoriaSeleccionada = categoria;
            }
        }
        return categoriaSeleccionada;
    }
}
