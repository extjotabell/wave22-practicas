package com.meli.be_java_hisp_w22_g01.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int user_id;
    private String user_name;
    @JsonIgnore
    private List<Seller> followed;
}
