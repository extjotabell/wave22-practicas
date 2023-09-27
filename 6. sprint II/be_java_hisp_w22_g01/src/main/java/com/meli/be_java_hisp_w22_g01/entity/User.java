package com.meli.be_java_hisp_w22_g01.entity;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    private int user_id;
    private String user_name;
    private List<Seller> followed;
}
