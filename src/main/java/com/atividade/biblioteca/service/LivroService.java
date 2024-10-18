package com.atividade.biblioteca.service;



import com.atividade.biblioteca.domains.Livro;
import com.atividade.biblioteca.domains.dtos.LivroDTO;
import com.atividade.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepo;

    public List<LivroDTO> findAll() {
        //retorna uma lista de GrupoProdutoDRO
        return livroRepo.findAll().stream()
                .map(obj -> new LivroDTO(obj))
                .collect(Collectors.toList());
    }

    public Livro findbyid(int id) {
        Optional<Livro> obj = livroRepo.findById(id);
        return obj.orElse(null);
    }
    public Livro findbyIsbn(String isbn){
        Optional<Livro> obj = livroRepo.findByIsbn(isbn);
        return obj.orElse(null);
    }
}