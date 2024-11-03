package com.atividade.biblioteca.resources;



import com.atividade.biblioteca.domains.Editora;
import com.atividade.biblioteca.domains.dtos.AutorDTO;
import com.atividade.biblioteca.domains.dtos.EditoraDTO;
import com.atividade.biblioteca.service.EditoraService;
import com.atividade.biblioteca.service.exceptions.DataIntegrityViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/editora")
public class EditoraResource {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public ResponseEntity<List<EditoraDTO>> findAll() {
        return ResponseEntity.ok().body(editoraService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EditoraDTO> findById(@PathVariable int id) {
        Editora obj = this.editoraService.findbyid(id);
        return ResponseEntity.ok().body(new EditoraDTO(obj));
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<EditoraDTO> findbyIsbn(@PathVariable String cnpj) {
        Editora obj = this.editoraService.findbyCnpj(cnpj);
        return ResponseEntity.ok().body(new EditoraDTO(obj));
    }

    @PostMapping
    public ResponseEntity<EditoraDTO> create(@Valid @RequestBody EditoraDTO dto) {
        Editora editora = editoraService.create(dto);
        //cria o URI para o Recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(editora.getId()).toUri();
        // retorna a resposta com o status 201 create e o local do recurso criado
        return ResponseEntity.created(uri).build();
    }
    @PutMapping
    public ResponseEntity<EditoraDTO> update(@PathVariable Integer id, @Valid @RequestBody EditoraDTO objDto){
        Editora obj = editoraService.update(id, objDto);
        return ResponseEntity.ok().body(new EditoraDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EditoraDTO> delete (@PathVariable Integer id){
        editoraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


