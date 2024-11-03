package com.atividade.biblioteca.service;


import com.atividade.biblioteca.domains.Autor;
import com.atividade.biblioteca.domains.dtos.AutorDTO;
import com.atividade.biblioteca.repositories.AutorRepository;
import com.atividade.biblioteca.service.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepo;

    public List<AutorDTO> findAll(){
        //retorna uma lista de GrupoProdutoDRO
        return autorRepo.findAll().stream()
                .map(obj -> new AutorDTO(obj))
                .collect(Collectors.toList());
    }
    public Autor findbyid(Long id){
        Optional<Autor> obj = autorRepo.findById(id);
        return obj.orElse(null);
    }

    public Autor create(AutorDTO dto){
        dto.setId(null);
        Autor obj = new Autor(dto);
        return autorRepo.save(obj);
    }
    public Autor update(Integer id, AutorDTO objDto){
        objDto.setId(id);
        Autor oldObj = findbyid(id.longValue());
        oldObj = new Autor(objDto);
        return autorRepo.save(oldObj);
    }
    public void delete(Long id){
        Autor obj = findbyid(id);
        if (obj.getLivros().size()>0){
            throw new DataIntegrityViolationException("Autor não pode ser deletado pois possui livros vinculados!");
        }
        autorRepo.deleteById(id);
    }


}
