
package com.argentinaPrograma.BackEndArgentinaPrograma.contr;

import com.argentinaPrograma.BackEndArgentinaPrograma.Security.Controller.Mensaje;
import com.argentinaPrograma.BackEndArgentinaPrograma.dto.PorfolioDto;
import com.argentinaPrograma.BackEndArgentinaPrograma.entity.Porfolio;
import com.argentinaPrograma.BackEndArgentinaPrograma.serv.PorfolioService;
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
@RequestMapping("/porfolio")
public class ControladorPorfolio {
    @Autowired
    PorfolioService porfolioService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Porfolio>> list() {
        List<Porfolio> list = porfolioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Porfolio> getById(@PathVariable("id") int id) {
        if (!porfolioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Porfolio porfolio = porfolioService.getOne(id).get();
        return new ResponseEntity(porfolio, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!porfolioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        porfolioService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PorfolioDto porfolioDto) {
        if (StringUtils.isBlank(porfolioDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (porfolioService.existsByNombre(porfolioDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Porfolio porfolio = new Porfolio(porfolioDto.getTitulo(), porfolioDto.getLink(), porfolioDto.getImagen(), porfolioDto.getTecnologias());
        porfolioService.save(porfolio);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PorfolioDto porfolioDto) {

        if (!porfolioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (porfolioService.existsByNombre(porfolioDto.getTitulo()) && porfolioService.getByNombre(porfolioDto.getTitulo()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(porfolioDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Porfolio porfolio = porfolioService.getOne(id).get();
        porfolio.setTitulo(porfolioDto.getTitulo());
        porfolio.setLink(porfolioDto.getLink());
        porfolio.setImagen(porfolioDto.getImagen());
        porfolio.setTecnologias(porfolioDto.getTecnologias());
        
        
        porfolioService.save(porfolio);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
