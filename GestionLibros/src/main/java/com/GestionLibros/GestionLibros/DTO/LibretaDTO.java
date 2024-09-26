package com.GestionLibros.GestionLibros.DTO;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class LibretaDTO {
    private Long id;
    private long id_usario;
    private  String nombre;
    private String usuario;
    private List<CapituloDTO> capitulos;
    private MultipartFile img;
    private String imgUrl;
    public LibretaDTO(Long id, String nombre, String usuario,
                      List<CapituloDTO> capitulos) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.capitulos = capitulos;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<CapituloDTO> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<CapituloDTO> capitulos) {
        this.capitulos = capitulos;
    }

    public long getId_usario() {
        return id_usario;
    }

    public void setId_usario(long id_usario) {
        this.id_usario = id_usario;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
