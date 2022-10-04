package com.argentinaPrograma.BackEndArgentinaPrograma.contr;

import com.argentinaPrograma.BackEndArgentinaPrograma.entity.Persona;
import com.argentinaPrograma.BackEndArgentinaPrograma.serv.IPersonaServicio;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorPersona {

    @Autowired
    IPersonaServicio iUserServicio;

    @GetMapping("/persona/ver")
    public ArrayList<Persona> getUsuario() {
        return iUserServicio.getUsuario();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/crear")
    public String crearUsuario(@RequestBody Persona user) {
        iUserServicio.saveUser(user);
        return "persona agregada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/borrar/{id}")
    public void borrarUsuario(@PathVariable Integer id) {
        iUserServicio.deleteUser(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/editar/{id}")
    public Persona editarPersona(@PathVariable Integer id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("imagen") String nuevoImagen,
            @RequestParam("sobreMi") String nuevoSobreMi,
            @RequestParam("puesto") String nuevoPuesto){

        Persona usuario = iUserServicio.findUser(id);

        
        usuario.setNombre(nuevoNombre);
        usuario.setApellido(nuevoApellido);
        usuario.setImagen(nuevoImagen);
        usuario.setSobreMi(nuevoSobreMi);
        usuario.setPuesto(nuevoPuesto);

        iUserServicio.saveUser(usuario);
        return usuario;

    }
}
