package interfaces;

import model.Cliente;

public interface CRUD<T,K>{

    boolean alta(T alta);
    boolean baja(T baja);
    void modificar(K key, T modificar);
    T consultar(K consulta);


}
