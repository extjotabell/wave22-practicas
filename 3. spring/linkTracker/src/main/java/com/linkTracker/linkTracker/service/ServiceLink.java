package com.linkTracker.linkTracker.service;

import com.linkTracker.linkTracker.dto.LinkIdDto;
import com.linkTracker.linkTracker.dto.LinkInputDto;
import com.linkTracker.linkTracker.entity.Link;
import com.linkTracker.linkTracker.exception.NotFoundException;
import com.linkTracker.linkTracker.repository.IRepositoryLink;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ServiceLink implements IServiceLink{

    private IRepositoryLink repositoryLink;

    public ServiceLink(IRepositoryLink repositoryLink) {
        this.repositoryLink = repositoryLink;
    }

    @Override
    public LinkIdDto createLink(LinkInputDto linkInputDto) {
        int linkId = repositoryLink.getLinkAmount()+1;
        Link link = new Link(linkId, linkInputDto.getOriginalUrl(), generateMaskedUrl(linkInputDto), linkInputDto.getPassword(), 0, true);
        repositoryLink.createLink(link);
        return new LinkIdDto(linkId);
    }

    @Override
    public String redirect(int linkId, String password) {
        Optional<Link> link = repositoryLink.getAllLinks().stream()
                .filter(l -> l.getLinkId() == linkId)
                .findFirst();
        if(link.isEmpty()){
            throw new NotFoundException("No existe un link con esa id");
        }

        if(!link.get().is_valid()){
            throw new NotFoundException("El link es inválido");
        }

        if(!password.equals(link.get().getPassword())){
            throw new NotFoundException("Contraseña incorrecta" + password + "/" + link.get().getPassword());
        }
        repositoryLink.addVisit(link.get());

        return link.get().getMaskedUrl();
    }

    @Override
    public int getMetrics(int linkId) {
        Optional<Link> link = getLinkById(linkId);

        if(link.isEmpty()){
            throw new NotFoundException("No existe un link con ese id");
        }

        return link.get().getRedirectCount();
    }

    @Override
    public void invalidateLink(int linkId) {
        Optional<Link> link = getLinkById(linkId);
        if(link.isEmpty()){
            throw new NotFoundException("No existe un link con ese id");
        }
        repositoryLink.invalidateLink(getLinkById(linkId).get());
    }

    public Optional<Link> getLinkById(int linkId){
        return repositoryLink.getAllLinks().stream()
                .filter(l -> l.getLinkId() == linkId)
                .findFirst();
    }

    private String generateMaskedUrl(LinkInputDto link) {
        String originalUrl = link.getOriginalUrl();
        return "https://mi-servicio.com/" + originalUrl + "/enlace/" + repositoryLink.getLinkAmount()+1;
    }

}
