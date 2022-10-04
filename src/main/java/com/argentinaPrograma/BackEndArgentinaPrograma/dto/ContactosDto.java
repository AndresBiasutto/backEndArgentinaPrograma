/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaPrograma.BackEndArgentinaPrograma.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author aquia
 */
public class ContactosDto {
    @NotBlank
    private String nombre;
    private String imagen;
    private String link;

    public ContactosDto() {
    }

    public ContactosDto(String nombre, String imagen, String link) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.link = link;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    
}
