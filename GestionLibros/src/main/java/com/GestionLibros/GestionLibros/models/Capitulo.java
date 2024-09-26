package com.GestionLibros.GestionLibros.models;

import jakarta.persistence.*;

@Entity

public class Capitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "libreta_id")
    private Libreta libreta;

    @Lob
    private String contenido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Libreta getLibreta() {
        return libreta;
    }

    public void setLibreta(Libreta libreta) {
        this.libreta = libreta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
