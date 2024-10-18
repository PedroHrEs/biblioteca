package com.atividade.biblioteca.repositories;


import com.atividade.biblioteca.domains.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditoraRepository extends JpaRepository<Editora,Integer> {
    Optional<Editora> findByCnpj(String cnpj);
}
