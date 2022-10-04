
package com.argentinaPrograma.BackEndArgentinaPrograma.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author aquia
 */
public class SkillsDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private int nivelSkill;
    @NotBlank
    private String imagen;
    @NotBlank
    
    public SkillsDto() {
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public SkillsDto(String nombre, int nivelSkill, String imagen) {
        this.nombre = nombre;
        this.nivelSkill = nivelSkill;
        this.imagen = imagen;
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelSkill() {
        return nivelSkill;
    }

    public void setNivelSkill(int nivelSkill) {
        this.nivelSkill = nivelSkill;
    }
}
