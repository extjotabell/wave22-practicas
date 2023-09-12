package Spring.EjercicioLinkTracker.Service;


import Spring.EjercicioLinkTracker.Dtos.CreateLinkDto;

public interface ILinkService {
     String createLink(CreateLinkDto linkDto);
     String redirect(Integer linkId);
     int getCantidadRedireccion(int link);

     boolean invalidateLink(int linkId);

}
