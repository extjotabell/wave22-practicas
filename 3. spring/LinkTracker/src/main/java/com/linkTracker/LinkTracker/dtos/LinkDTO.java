package com.linkTracker.LinkTracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    private String url;
    private int id;
    private int count;
    private int pass;
    private boolean active;
}
