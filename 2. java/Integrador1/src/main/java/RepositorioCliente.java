import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioCliente implements Crud<Cliente>{

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void alta(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void baja(Cliente cliente) {
        Cliente aEliminar = clientes.stream().filter(c-> c.getDni() == cliente.getDni()).findFirst().get();
        clientes.remove(aEliminar);
    }

    @Override
    public Optional<Cliente> consulta(int dni) {
        Optional<Cliente> clienteOptional = clientes.stream().filter(c-> c.getDni() == dni).findFirst();
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + " DNI: " + cliente.getDni());
            return clienteOptional;
        } else {
            System.out.println("Cliente con DNI " + dni + " no encontrado.");
            return Optional.empty();
        }
    }
}
