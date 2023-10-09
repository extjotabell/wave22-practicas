package vehiculosHQL.vehiculosHQL.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import vehiculosHQL.vehiculosHQL.dto.RespuestaDTO;
import vehiculosHQL.vehiculosHQL.dto.VehiculoDto;
import vehiculosHQL.vehiculosHQL.entity.Siniestro;
import vehiculosHQL.vehiculosHQL.entity.Vehiculo;
import vehiculosHQL.vehiculosHQL.repository.VehiculoRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{
    VehiculoRepository repo;

    public VehiculoService(VehiculoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<RespuestaDTO> todasPatentes() {
        List<RespuestaDTO> respuesta = repo.listaPatentes().stream().map(RespuestaDTO::new).toList();
        return respuesta;
    }

    @Override
    public List<RespuestaDTO> patentesPorAño() {
        List<Object[]> vehiculos = repo.listaPatenteMarcaAño();
        List<RespuestaDTO> respuesta = vehiculos.stream().map(v -> new RespuestaDTO("Patente: " + v[0] + " Marca: " + v[1])).toList();
        return respuesta;
    }

    @Override
    public List<RespuestaDTO> patentesPorRuedas() {
        List<String> patentes = repo.listaRuedasAño();
        List<RespuestaDTO> respuesta = patentes.stream().map(v -> new RespuestaDTO(v)).toList();
        return respuesta;
    }

    @Override
    public List<RespuestaDTO> patentePorSiniestro() {
        List<Object[]> vehiculos = repo.perdidaEconomica();
        List<RespuestaDTO> respuesta = vehiculos.stream().map(v -> new RespuestaDTO("Patente: " + v[0] + " Marca: " + v[1] + " Modelo: " + v[2])).toList();
        return respuesta;
    }

    @Override
    public List<RespuestaDTO> patentePerdidaTotal() {
        List<Object[]> vehiculos = repo.perdidaTotal();
        List<RespuestaDTO> respuesta = vehiculos.stream().map(v-> new RespuestaDTO("Patente: " + v[0] + " Marca: " + v[1] + " Modelo: " + v[2] + " Perdida: " + v[3])).toList();
        return respuesta;
    }

    @Override
    public String guardar(VehiculoDto vehiculo) {
        ModelMapper mapper = new ModelMapper();
        Vehiculo newVehiculo = mapper.map(vehiculo, Vehiculo.class);
        Set<Siniestro> siniestros = vehiculo.getSiniestros().stream().map(s-> mapper.map(s,Siniestro.class)).collect(Collectors.toSet());
        newVehiculo.setSiniestros(siniestros);
        System.out.println(newVehiculo);
        repo.save(newVehiculo);
        return "Guardado";
    }
}
