package com.atividade.biblioteca.resources;


import com.atividade.biblioteca.domains.Autor;
import com.atividade.biblioteca.domains.dtos.AutorDTO;
import com.atividade.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/autor")
public class AutorResource {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorDTO>> findAll(){

        return ResponseEntity.ok().body(autorService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AutorDTO> findById(@PathVariable Long id){
        Autor obj = this.autorService.findbyid(id);
        return ResponseEntity.ok().body(new AutorDTO(obj));
    }

}
