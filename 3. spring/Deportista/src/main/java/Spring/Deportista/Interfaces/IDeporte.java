package Spring.Deportista.Interfaces;

import Spring.Deportista.Domain.Dto.DeporteDto;
import Spring.Deportista.Domain.Dto.DeporteNivelDto;

import java.util.ArrayList;

public interface IDeporte {
    ArrayList<DeporteDto> findSports();
    DeporteNivelDto sportsByName(String name);
}
