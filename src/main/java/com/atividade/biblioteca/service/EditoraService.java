package com.atividade.biblioteca.service;


import com.atividade.biblioteca.domains.Autor;
import com.atividade.biblioteca.domains.Editora;
import com.atividade.biblioteca.domains.Livro;
import com.atividade.biblioteca.domains.dtos.EditoraDTO;
import com.atividade.biblioteca.domains.dtos.LivroDTO;
import com.atividade.biblioteca.repositories.EditoraRepository;
import com.atividade.biblioteca.service.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepo;

    public List<EditoraDTO> findAll() {
        //retorna uma lista de GrupoProdutoDRO
        return editoraRepo.findAll().stream()
                .map(obj -> new EditoraDTO(obj))
                .collect(Collectors.toList());
    }

    public Editora findbyid(int id) {
        Optional<Editora> obj = editoraRepo.findById(id);
        return obj.orElse(null);
    }
    public Editora findbyCnpj(String cnpj){
        Optional<Editora> obj = editoraRepo.findByCnpj(cnpj);
        return obj.orElse(null);

    }
    public Editora create(EditoraDTO dto){
        dto.setId(null);
        validaEditora(dto);
        Editora obj = new Editora(dto);
        return editoraRepo.save(obj);
    }
    public Editora update(Integer id, EditoraDTO objDto){
        objDto.setId(id);
        Editora oldObj = findbyid(id);
        oldObj = new Editora(objDto);
        return editoraRepo.save(oldObj);
    }
    public void validaEditora(EditoraDTO dto){
        Optional<Editora> obj = editoraRepo.findByCnpj(dto.getCnpj());
        if(obj.isPresent() && obj.get().getId() != dto.getId()){
            throw new DataIntegrityViolationException("CNPJ já cadastrado!");
        }

    }
    public void delete(Integer id){
        Editora obj = findbyid(id);
        if (obj.getLivros().size()>0){
            throw new DataIntegrityViolationException("Editora não pode ser deletado pois possui livros vinculados!");
        }
        editoraRepo.deleteById(id);
    }
}