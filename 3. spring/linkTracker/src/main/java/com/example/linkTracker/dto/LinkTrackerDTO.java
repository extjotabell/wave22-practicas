package com.example.linkTracker.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkTrackerDTO {
    private Integer id;
    private String urlEnmascarada;
    private Integer contadorVisitas;
    private boolean invalidate;
    private String password;

    public LinkTrackerDTO(String urlEnmascarada, Integer contadorVisitas, String password) {
        this.urlEnmascarada = urlEnmascarada;
        this.contadorVisitas = contadorVisitas;
        this.invalidate = false;
        this.password = password;
    }
}