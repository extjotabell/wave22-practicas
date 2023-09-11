package com.example.link_tracker.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    Integer linkId;
    Integer redirectCount = 0;
    Boolean isActive;
    String password;
    String url;

    public void setRedirectCount() {
        this.redirectCount = redirectCount + 1;
    }
}
