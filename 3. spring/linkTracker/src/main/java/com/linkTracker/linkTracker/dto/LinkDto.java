package com.linkTracker.linkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkDto {
    private int linkId;
    private String originalUrl;
    private String password;
}
