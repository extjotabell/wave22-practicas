package save_the_ropa;

public class Remera extends Prenda{
    private String color;
    private boolean esMangaLarga;

    public Remera(String marca, String modelo, String color, boolean esMangaLarga) {
        super(marca, modelo);
        this.color = color;
        this.esMangaLarga = esMangaLarga;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEsMangaLarga() {
        return esMangaLarga;
    }

    public void setEsMangaLarga(boolean esMangaLarga) {
        this.esMangaLarga = esMangaLarga;
    }

    @Override
    public String toString() {
        return "Remera{" +
                "color='" + color + '\'' +
                ", esMangaLarga=" + esMangaLarga +
                '}';
    }
}
