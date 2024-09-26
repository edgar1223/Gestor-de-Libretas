package com.GestionLibros.GestionLibros.DTO;

public class CapituloDTO
    {
        private String titulo;

        public CapituloDTO(String titulo) {
            this.titulo = titulo;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
    }
