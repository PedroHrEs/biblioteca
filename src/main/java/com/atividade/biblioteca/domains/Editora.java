package com.atividade.biblioteca.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_editora")
    private int id;

    @NotNull @NotBlank
    private String cnpj;

    @NotNull @NotBlank
    private String razaoSocial;

    @JsonManagedReference
    @OneToMany(mappedBy = "Editora")
    private List<Livro> livros = new ArrayList<>();

    public Editora() {
    }

    public Editora(int id, String cnpj, String razaoSocial, List<Livro> livros) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.livros = livros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull @NotBlank String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull @NotBlank String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull @NotBlank String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editora editora = (Editora) o;
        return id == editora.id && Objects.equals(cnpj, editora.cnpj) && Objects.equals(razaoSocial, editora.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj, razaoSocial);
    }
}
