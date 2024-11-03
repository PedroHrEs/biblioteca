package com.atividade.biblioteca.resources;


import com.atividade.biblioteca.domains.Autor;
import com.atividade.biblioteca.domains.Editora;
import com.atividade.biblioteca.domains.dtos.AutorDTO;
import com.atividade.biblioteca.service.AutorService;
import com.atividade.biblioteca.service.exceptions.DataIntegrityViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @PostMapping
    public ResponseEntity<AutorDTO> create(@Valid @RequestBody AutorDTO dto){
        Autor autor = autorService.create(dto);
        //cria o URI para o Recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();
        // retorna a resposta com o status 201 create e o local do recurso criado
        return ResponseEntity.created(uri).build();
    }
    @PutMapping
    public ResponseEntity<AutorDTO> update(@PathVariable Integer id, @Valid @RequestBody AutorDTO objDto){
        Autor obj = autorService.update(id, objDto);
        return ResponseEntity.ok().body(new AutorDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AutorDTO> delete (@PathVariable Long id){
        autorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
