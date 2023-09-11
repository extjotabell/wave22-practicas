package com.linkTracker.LinkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private int id;
    private String url;
    private int count;
    private int pass;
    private boolean active;
}
