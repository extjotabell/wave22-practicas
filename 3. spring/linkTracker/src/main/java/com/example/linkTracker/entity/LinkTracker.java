package com.example.linkTracker.entity;

import com.example.linkTracker.dto.LinkTrackerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkTracker {

    private Integer id;
    private String urlEnmascarada;
    private Integer contadorVisitas;
    private boolean invalidate;
    private String password;

    public LinkTracker(String urlEnmascarada, String password) {
        this.urlEnmascarada = urlEnmascarada;
        this.contadorVisitas = 0;
        this.invalidate = false;
        this.password = password;
    }
}
