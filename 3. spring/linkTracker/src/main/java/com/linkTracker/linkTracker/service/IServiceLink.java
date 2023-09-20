package com.linkTracker.linkTracker.service;

import com.linkTracker.linkTracker.dto.LinkDto;
import com.linkTracker.linkTracker.dto.LinkIdDto;
import com.linkTracker.linkTracker.dto.LinkInputDto;
import org.springframework.http.HttpHeaders;

public interface IServiceLink {
    LinkIdDto createLink(LinkInputDto linkInputDto);
    String redirect(int linkId, String password);
    int getMetrics(int linkId);
    void invalidateLink(int linkId);
}
