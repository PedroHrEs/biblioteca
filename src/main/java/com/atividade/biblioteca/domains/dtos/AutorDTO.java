package com.atividade.biblioteca.domains.dtos;


import com.atividade.biblioteca.domains.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AutorDTO {


    private Integer id;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo documentoPessoal não pode ser nulo!")
    @NotBlank(message = "O campo documentoPessoal não pode ser vazio!")
    private String documentoPessoal;

    public AutorDTO() {
    }

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.documentoPessoal = autor.getDocumentoPessoal();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo documentoPessoal não pode ser nulo!") @NotBlank(message = "O campo documentoPessoal não pode ser vazio!") String getDocumentoPessoal() {
        return documentoPessoal;
    }

    public void setDocumentoPessoal(@NotNull(message = "O campo documentoPessoal não pode ser nulo!") @NotBlank(message = "O campo documentoPessoal não pode ser vazio!") String documentoPessoal) {
        this.documentoPessoal = documentoPessoal;
    }
}
