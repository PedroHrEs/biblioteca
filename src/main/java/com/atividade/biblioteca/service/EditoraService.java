package com.atividade.biblioteca.service;


import com.atividade.biblioteca.domains.Autor;
import com.atividade.biblioteca.domains.Editora;
import com.atividade.biblioteca.domains.dtos.EditoraDTO;
import com.atividade.biblioteca.repositories.EditoraRepository;
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
}