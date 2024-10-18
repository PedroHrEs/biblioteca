package com.atividade.biblioteca.repositories;


import com.atividade.biblioteca.domains.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {

}
