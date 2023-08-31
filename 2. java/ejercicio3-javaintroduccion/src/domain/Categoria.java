package domain;

import java.util.Map;

public class Categoria {

    private static int idCache = 0;
    private final int id;
    private Enum<TipoCategoria> tipoCategoria;
    private String descripcionCategoria;

    public Categoria() {
        this.id = idCache++;
    }

    public Categoria(Enum<domain.TipoCategoria> tipoCategoria, String descripcionCategoria) {
        this();
        this.tipoCategoria = tipoCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public int getId() {
        return id;
    }

    public Enum<domain.TipoCategoria> getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(Enum<domain.TipoCategoria> tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", tipoCategoria=" + tipoCategoria +
                ", descripcionCategoria='" + descripcionCategoria + '\'' +
                '}';
    }
}
