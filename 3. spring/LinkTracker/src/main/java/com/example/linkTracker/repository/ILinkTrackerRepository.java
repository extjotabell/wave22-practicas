package com.example.linkTracker.repository;
import com.example.linkTracker.entity.LinkTracker;

import java.util.Optional;

public interface ILinkTrackerRepository {
    Optional<LinkTracker> findById(Integer linkId);
    Integer save(LinkTracker linkTracker);
    boolean existePorId(int id);
    void invalidateLink(Integer linkId);
    void update(LinkTracker linkTracker);
}
