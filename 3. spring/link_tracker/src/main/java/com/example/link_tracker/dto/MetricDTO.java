package com.example.link_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MetricDTO {
    private Integer linkId;
    private Integer redirectCount;
    private String url;
}
