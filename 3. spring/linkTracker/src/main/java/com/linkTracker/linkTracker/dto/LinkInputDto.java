package com.linkTracker.linkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkInputDto {
    private String originalUrl;
    private String password;
}
