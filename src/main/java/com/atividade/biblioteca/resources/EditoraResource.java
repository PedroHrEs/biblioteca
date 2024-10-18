package com.atividade.biblioteca.resources;



import com.atividade.biblioteca.domains.Editora;
import com.atividade.biblioteca.domains.dtos.EditoraDTO;
import com.atividade.biblioteca.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/editora")
public class EditoraResource {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public ResponseEntity<List<EditoraDTO>> findAll(){
        return  ResponseEntity.ok().body(editoraService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EditoraDTO> findById(@PathVariable int id){
        Editora obj = this.editoraService.findbyid(id);
        return ResponseEntity.ok().body(new EditoraDTO(obj));
    }
    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<EditoraDTO> findbyIsbn(@PathVariable String cnpj){
        Editora obj = this.editoraService.findbyCnpj(cnpj);
        return ResponseEntity.ok().body(new EditoraDTO(obj));
    }
}


