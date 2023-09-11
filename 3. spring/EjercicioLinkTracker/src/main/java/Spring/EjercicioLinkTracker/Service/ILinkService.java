package Spring.EjercicioLinkTracker.Service;


import Spring.EjercicioLinkTracker.Dtos.CreateLinkDto;
import Spring.EjercicioLinkTracker.Entities.Link;

import java.util.List;

public interface ILinkService {
     String createLink(CreateLinkDto linkDto);
     String redirect(Integer linkId);
     Integer getCantidadRedirecciones(String link);

     boolean invalidateLink(String linkId);
     List<Link> getAll();

}
