
package com.argentinaPrograma.BackEndArgentinaPrograma.contr;

import com.argentinaPrograma.BackEndArgentinaPrograma.Security.Controller.Mensaje;
import com.argentinaPrograma.BackEndArgentinaPrograma.dto.ContactosDto;
import com.argentinaPrograma.BackEndArgentinaPrograma.entity.Contactos;
import com.argentinaPrograma.BackEndArgentinaPrograma.serv.ContactosService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contactos")
public class ControladorContactos {
    @Autowired
    ContactosService contactosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Contactos>> list() {
        List<Contactos> list = contactosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Contactos> getById(@PathVariable("id") int id) {
        if (!contactosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Contactos hYs = contactosService.getOne(id).get();
        return new ResponseEntity(hYs, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!contactosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        contactosService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ContactosDto contactosDto) {
        if (StringUtils.isBlank(contactosDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (contactosService.existsByNombre(contactosDto.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Contactos skill = new Contactos(contactosDto.getNombre(), contactosDto.getLink(), contactosDto.getImagen());
        contactosService.save(skill);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ContactosDto contacto) {
        //Validamos si existe el ID
        if (!contactosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (contactosService.existsByNombre(contacto.getNombre()) && contactosService.getByNombre(contacto.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(contacto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Contactos contactos = contactosService.getOne(id).get();
        contactos.setNombre(contacto.getNombre());
        contactos.setImagen(contacto.getImagen());
        contactos.setLink(contacto.getLink());

        contactosService.save(contactos);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
