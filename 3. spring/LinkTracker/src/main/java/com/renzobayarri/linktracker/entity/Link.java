package com.renzobayarri.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    private int linkId;

    private String url;

    private int quantity;

    private boolean active;

    private String password;
}
