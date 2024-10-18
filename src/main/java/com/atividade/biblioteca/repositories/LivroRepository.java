package com.atividade.biblioteca.repositories;


import com.atividade.biblioteca.domains.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    Optional<Livro> findByIsbn(String isbn);
}
