package com.example.linkTracker.service;
import com.example.linkTracker.dto.LinkTrackerDTO;
import org.springframework.web.servlet.view.RedirectView;


public interface ILinkTrackerService {
    LinkTrackerDTO findLinkById(Integer linkId);
    Integer saveLink(LinkTrackerDTO linkTracker);
    boolean existePorId(int id);
    void invalidateLink(Integer linkId);
    void addOneVisit(int id);
    RedirectView redirect(Integer id, String password);
}
