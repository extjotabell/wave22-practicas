package com.example.linkTracker.service;

import com.example.linkTracker.dto.LinkTrackerDTO;
import com.example.linkTracker.entity.LinkTracker;
import com.example.linkTracker.exceptions.IncorrectPasswordException;
import com.example.linkTracker.exceptions.LinkInvalidatedException;
import com.example.linkTracker.exceptions.LinkNotFoundException;
import com.example.linkTracker.repository.ILinkTrackerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LinkTrackerServiceImpl implements ILinkTrackerService {

    private final ILinkTrackerRepository iLinkTrackerRepository;

    @Override
    public LinkTrackerDTO findLinkById(Integer linkId) {

        Optional<LinkTracker> linkTrackerOptional = iLinkTrackerRepository.findById(linkId);

        if (linkTrackerOptional.isEmpty()) {
            throw new LinkNotFoundException(linkId);
        }
        LinkTracker link = iLinkTrackerRepository.findById(linkId).get();

        return new LinkTrackerDTO(link.getUrlEnmascarada(), link.getContadorVisitas(), link.getPassword());
    }
    @Override
    public void addOneVisit(int id){
        LinkTracker link = iLinkTrackerRepository.findById(id).get();
        link.setContadorVisitas(link.getContadorVisitas()+1);
        iLinkTrackerRepository.update(link);
    }

    @Override
    public RedirectView redirect(Integer id, String password) {
        LinkTracker tracker = iLinkTrackerRepository.findById(id).get();
        if(tracker.isInvalidate()){
            throw new LinkInvalidatedException(id);
        }
        if(!tracker.getPassword().equals(password)){
            throw new IncorrectPasswordException();
        }
        addOneVisit(id);
        return new RedirectView(tracker.getUrlEnmascarada());
    }

    @Override
    public Integer saveLink(LinkTrackerDTO linkTracker) {
        LinkTracker link = new LinkTracker(linkTracker.getUrlEnmascarada(), linkTracker.getPassword());
        return iLinkTrackerRepository.save(link);

    }

    @Override
    public boolean existePorId(int id) {
        return iLinkTrackerRepository.existePorId(id);
    }

    @Override
    public void invalidateLink(Integer linkId) {
        iLinkTrackerRepository.invalidateLink(linkId);
    }

}
