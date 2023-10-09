package vehiculosHQL.vehiculosHQL.service;

import vehiculosHQL.vehiculosHQL.dto.RespuestaDTO;
import vehiculosHQL.vehiculosHQL.dto.VehiculoDto;

import java.util.List;

public interface IVehiculoService {
    List<RespuestaDTO> todasPatentes();
    List<RespuestaDTO> patentesPorAño();
    List<RespuestaDTO> patentesPorRuedas();
    List<RespuestaDTO> patentePorSiniestro();
    List<RespuestaDTO> patentePerdidaTotal();
    String guardar(VehiculoDto vehiculo);
}
