package com.linkTracker.linkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {
    private int linkId;
    private String originalUrl;
    private String maskedUrl;
    private String password;
    private int redirectCount;
    private boolean is_valid;
}
