package com.example.link_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkDTO {
    Integer linkId;
    Integer countRedirecciones = 0;
    // Estado de si es valido o invalido el link
    Boolean estado;
    String contrasena;
    String url;


    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Integer getCountRedirecciones() {
        return countRedirecciones;
    }

    public void setCountRedirecciones(Integer countRedirecciones) {
        this.countRedirecciones = countRedirecciones;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void sumarRedict(){
        this.countRedirecciones+=1;
    }
}
