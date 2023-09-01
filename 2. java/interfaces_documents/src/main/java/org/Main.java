package org;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Documento> documentos = new ArrayList<>();

        documentos.add(new LibroPdf("Nombre pdf", "Autor pdf"));
        documentos.add(new Curriculum(12345678, "Nombre cv", new String[]{"habilidad 1","habilidad 2"}));
        documentos.add(new Informe("Texto informe", 23, "Autor informe", "Revisor informe"));

        documentos.forEach(Imprimible::imprimir);
    }
}