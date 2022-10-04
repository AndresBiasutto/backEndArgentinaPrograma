
package com.argentinaPrograma.BackEndArgentinaPrograma.dto;


public class PorfolioDto {
    private String titulo;
    private String link;
    private String tecnologias;
    private String imagen;

    public PorfolioDto() {
    }

    public PorfolioDto(String titulo, String link, String tecnologias, String imagen) {
        this.titulo = titulo;
        this.link = link;
        this.tecnologias = tecnologias;
        this.imagen = imagen;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
