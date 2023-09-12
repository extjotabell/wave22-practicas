package com.example.blogProyect.entity;

import java.util.Date;

public class EntradaBlog {
    private int idBlog;
    private String titulo;
    private String autor;
    private Date fecha;

    public EntradaBlog() {
    }

    public EntradaBlog(int idBlog, String titulo, String autor, Date fecha) {
        this.idBlog = idBlog;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
    }

    public int getIdBlog() {
        return idBlog;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Date getFecha() {
        return fecha;
    }


}
