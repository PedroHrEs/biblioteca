package com.atividade.biblioteca.service;



import com.atividade.biblioteca.domains.Autor;
import com.atividade.biblioteca.domains.Editora;
import com.atividade.biblioteca.domains.Livro;
import com.atividade.biblioteca.domains.dtos.LivroDTO;
import com.atividade.biblioteca.repositories.LivroRepository;
import com.atividade.biblioteca.service.exceptions.DataIntegrityViolationException;
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

    public Livro findbyid(Integer id) {
        Optional<Livro> obj = livroRepo.findById(id);
        return obj.orElse(null);
    }

    public Livro findbyIsbn(String isbn) {
        Optional<Livro> obj = livroRepo.findByIsbn(isbn);
        return obj.orElse(null);
    }

    public Livro create(LivroDTO dto) {
        dto.setId(null);
        validaLivro(dto);
        Livro obj = new Livro(dto);
        return livroRepo.save(obj);
    }

    public void validaLivro(LivroDTO dto) {
        Optional<Livro> obj = livroRepo.findByIsbn(dto.getIsbn());
        if (obj.isPresent() && obj.get().getIdLivro() != dto.getId()) {
            throw new DataIntegrityViolationException("ISBN já cadastrado!");
        }

        Optional<Editora> editora = editoraRepo.findById(dto.getEditora());
        if (!editora.isPresent()) {
            throw new DataIntegrityViolationException("Editora - " + dto.getEditora() + " não está cadastrado!");
        }
        Optional<Autor> autor = autorRepo.findById(dto.getAutor());
        if (!autor.isPresent()) {
            throw new DataIntegrityViolationException("Autor - " + dto.getAutor() + " não está cadastrado!");
        }
    }
    public Livro update(Integer id, LivroDTO objDto){
        objDto.setId(Long.valueOf(id));
        Livro oldObj = findbyid(id);
        validaLivro(objDto);
        oldObj = new Livro(objDto);
        return livroRepo.save(oldObj);
    }
    public void delete (Integer id){
        Livro obj = findbyid(id);
        livroRepo.deleteById(id);
    }
}