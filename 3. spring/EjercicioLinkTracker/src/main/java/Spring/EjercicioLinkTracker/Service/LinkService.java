package Spring.EjercicioLinkTracker.Service;

import Spring.EjercicioLinkTracker.Dtos.CreateLinkDto;
import Spring.EjercicioLinkTracker.Entities.Link;
import Spring.EjercicioLinkTracker.Exceptions.InvalidFormatException;
import Spring.EjercicioLinkTracker.Exceptions.LinkNotFoundException;
import Spring.EjercicioLinkTracker.Repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {

    @Autowired
    private ILinkRepository linkRepository;
    private static String NOT_FOUND_ERROR_MESSAGE = "No se encontro el link en la base de datos";
    private static String REDIRECT_404 = "/error/404";

    @Override
    public String createLink(CreateLinkDto linkDto) {
        Link newLink = new Link(linkDto.getUrl(), linkDto.getPassword());
        return linkRepository.createLink(newLink).getUrl();
    }

    @Override
    public String redirect(Integer linkId){
        Link link = linkRepository.getLink(linkId);
        return link != null ? link.getUrl() : REDIRECT_404;
    }

    @Override public int getCantidadRedireccion(int id) {
        Link link = validarIdLink(id);
        if (link != null)
            return link.getCantidadRedireciones();
        else
            throw new LinkNotFoundException(NOT_FOUND_ERROR_MESSAGE);
    }

    @Override
    public boolean invalidateLink(int linkId) {
        Link link = validarIdLink(linkId);
        if (link != null)
            link.setActivo(false);
        else throw new LinkNotFoundException(NOT_FOUND_ERROR_MESSAGE);
        return true;
    }

    private Link validarIdLink(int id){
        Link link = new Link();
        try {
            link= linkRepository.getLink(id);
        if(!link.isActivo()) throw new InvalidFormatException("El link no se encuentra activo");
        } catch (NumberFormatException e) {
            throw new InvalidFormatException("El id no es numero");
        }
        return link;
    }
}
