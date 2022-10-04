/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaPrograma.BackEndArgentinaPrograma.serv;

import com.argentinaPrograma.BackEndArgentinaPrograma.entity.Persona;
import com.argentinaPrograma.BackEndArgentinaPrograma.repo.IRepoPersona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicio implements IPersonaServicio{

    @Autowired IRepoPersona UsuarioRepo;

    @Override
    public ArrayList<Persona> getUsuario() {
       List<Persona> usuario = UsuarioRepo.findAll();
       return (ArrayList<Persona>) usuario;
    }

    @Override
    public void saveUser(Persona persona) {
        UsuarioRepo.save(persona);
    }

    @Override
    public void deleteUser(Integer id) {
        UsuarioRepo.deleteById(id);
    }

    @Override
    public Persona findUser(Integer id) {
        Persona persona= UsuarioRepo.findById(id).orElse(null);
        return persona;
    }
    
}
