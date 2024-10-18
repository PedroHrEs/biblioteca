package com.atividade.biblioteca.domains.dtos;


import com.atividade.biblioteca.domains.Editora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EditoraDTO {

    private int id;


    @NotNull(message = "O campo cnpj não pode ser nulo!")
    @NotBlank(message = "O campo cnpj não pode ser vazio!")
    private String cnpj;

    @NotNull(message = "O campo razaoSocial não pode ser nulo!")
    @NotBlank(message = "O campo razaoSocial não pode ser vazio!")
    private String razaoSocial;

    public EditoraDTO() {
    }

    public EditoraDTO(Editora editora) {
        this.id = editora.getId();
        this.cnpj = editora.getCnpj();
        this.razaoSocial = editora.getRazaoSocial();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "O campo cnpj não pode ser nulo!") @NotBlank(message = "O campo cnpj não pode ser vazio!") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo cnpj não pode ser nulo!") @NotBlank(message = "O campo cnpj não pode ser vazio!") String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull(message = "O campo razaoSocial não pode ser nulo!") @NotBlank(message = "O campo razaoSocial não pode ser vazio!") String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull(message = "O campo razaoSocial não pode ser nulo!") @NotBlank(message = "O campo razaoSocial não pode ser vazio!") String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
