/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argentinaPrograma.BackEndArgentinaPrograma.serv;

import com.argentinaPrograma.BackEndArgentinaPrograma.entity.Persona;
import java.util.ArrayList;

/**
 *
 * @author aquia
 */
public interface IPersonaServicio {
        public ArrayList<Persona> getUsuario();
    
    public void saveUser(Persona usuario);
    
    public void deleteUser(Integer id);
    
    public Persona findUser(Integer id);
}
