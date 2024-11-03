package com.atividade.biblioteca.resources;


import com.atividade.biblioteca.domains.Editora;
import com.atividade.biblioteca.domains.Livro;
import com.atividade.biblioteca.domains.dtos.AutorDTO;
import com.atividade.biblioteca.domains.dtos.EditoraDTO;
import com.atividade.biblioteca.domains.dtos.LivroDTO;
import com.atividade.biblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/livro")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll() {
        return ResponseEntity.ok().body(livroService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable int id) {
        Livro obj = this.livroService.findbyid(id);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @GetMapping(value = "/isbn/{isbn}")
    public ResponseEntity<LivroDTO> findbyIsbn(@PathVariable String isbn) {
        Livro obj = this.livroService.findbyIsbn(isbn);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @PostMapping
    public ResponseEntity<LivroDTO> create(@Valid @RequestBody LivroDTO dto) {
        Livro livro = livroService.create(dto);
        //cria o URI para o Recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getIdLivro()).toUri();
        // retorna a resposta com o status 201 create e o local do recurso criado
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Integer id, @Valid @RequestBody LivroDTO objDTO){
        Livro obj = livroService.update(id, objDTO);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AutorDTO> delete(@PathVariable Integer id){
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
