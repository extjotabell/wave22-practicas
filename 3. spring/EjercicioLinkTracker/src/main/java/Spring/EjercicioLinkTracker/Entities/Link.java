package Spring.EjercicioLinkTracker.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {
    private int id;
    private String url;
    private int cantidadRedireciones;
    private boolean activo;
    private String password;

    public Link(String url, String password) {
        this.url = url;
        this.password = password;
    }
}