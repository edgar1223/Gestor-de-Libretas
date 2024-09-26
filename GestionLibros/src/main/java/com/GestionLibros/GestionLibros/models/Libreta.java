package com.GestionLibros.GestionLibros.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity

public class Libreta
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;

        private String img;

        @OneToMany(mappedBy = "libreta", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Capitulo> capitulos;

        @ManyToOne
        @JoinColumn(name = "usuario_id")
        private Usuario usuario;
        public Libreta() {
            // Inicializa la lista de capítulos como vacía, para evitar NPEs.
            this.capitulos = new ArrayList<>();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public List<Capitulo> getCapitulos() {
            return capitulos;
        }

        public void setCapitulos(List<Capitulo> capitulos) {
            this.capitulos = capitulos;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
