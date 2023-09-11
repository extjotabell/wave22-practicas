package Spring.EjercicioLinkTracker.Service;

import Spring.EjercicioLinkTracker.Dtos.CreateLinkDto;
import Spring.EjercicioLinkTracker.Entities.Link;
import Spring.EjercicioLinkTracker.Exceptions.InvalidFormatException;
import Spring.EjercicioLinkTracker.Exceptions.LinkNotFoundException;
import Spring.EjercicioLinkTracker.Repository.ILinkRepository;
import Spring.EjercicioLinkTracker.Repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService implements ILinkService {

    @Autowired
    private LinkRepository linkRepository;
    private static String NOT_FOUND_ERROR_MESSAGE = "No se encontró el link en la base de datos";
    private static String REDIRECT_404 = "/error/404";

    @Override
    public String createLink(CreateLinkDto linkDto) {
        var link = new Link(linkDto.getUrl(), linkDto.getPassword());
        return linkRepository.createLink(link).getUrl();
    }

    @Override
    public String redirect(Integer linkId){
        Link link = linkRepository.getLink(linkId);
        if(link != null){
            link.setCantidadRedireciones(link.getCantidadRedireciones() + 1);
            return link.getUrl();
        }
        return REDIRECT_404;
    }

    @Override
    public Integer getCantidadRedirecciones(String id) {
        Link link = validarIdLink(id);
        if (link != null)
            return link.getCantidadRedireciones();
        else
            throw new LinkNotFoundException(NOT_FOUND_ERROR_MESSAGE);
    }

    @Override
    public boolean invalidateLink(String linkId) {
        Link link = validarIdLink(linkId);
        if (link != null)
            link.setActivo(false);
        else throw new LinkNotFoundException(NOT_FOUND_ERROR_MESSAGE);
        return true;
    }

    @Override
    public List<Link> getAll() {
        return linkRepository.getAllLinks();
    }

    private Link validarIdLink(String id){
        var link = new Link();
        try {
             link = linkRepository.getLink(Integer.parseInt(id));
            if(link != null && !link.isActivo()){
                throw new InvalidFormatException("El link no se encuentra activo");
            }
        } catch (NumberFormatException e) {
            throw new InvalidFormatException("id debe ser un numero");
        }
        return link;
    }
}
