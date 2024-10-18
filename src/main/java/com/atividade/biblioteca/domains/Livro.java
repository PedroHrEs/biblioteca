package com.atividade.biblioteca.domains;


import com.atividade.biblioteca.domains.enums.Conservacao;
import com.atividade.biblioteca.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_livro")
    private long idLivro;

    @NotBlank @NotNull
    private String titulo;

    @NotBlank @NotNull
    private String isbn;

    @NotNull
    @Digits(integer = 10, fraction = 0)
    private int numeroPaginas;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;

    @NotNull
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorCompra;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="idautor")
    private Autor autor;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="ideditora")
    private Editora editora;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="status")
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="conservacao")
    private Conservacao conservacao;

    public Livro() {
        this.numeroPaginas = 0;
        this.valorCompra = BigDecimal.ZERO;
        this.status = Status.NAOLIDO;
        this.conservacao = Conservacao.EXCELENTE;
    }

    public Livro(long idLivro, String titulo, String isbn, int numeroPaginas, LocalDate dataCompra, BigDecimal valorCompra, Autor autor, Editora editora, Status status, Conservacao conservacao) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
        this.autor = autor;
        this.editora = editora;
        this.status = status;
        this.conservacao = conservacao;
    }

    public long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(long idLivro) {
        this.idLivro = idLivro;
    }

    public @NotBlank @NotNull String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank @NotNull String titulo) {
        this.titulo = titulo;
    }

    public @NotBlank @NotNull String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotBlank @NotNull String isbn) {
        this.isbn = isbn;
    }

    @NotNull
    @Digits(integer = 10, fraction = 0)
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(@NotNull @Digits(integer = 10, fraction = 0) int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public @NotNull @Digits(integer = 15, fraction = 3) BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(@NotNull @Digits(integer = 15, fraction = 3) BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Conservacao getConservacao() {
        return conservacao;
    }

    public void setConservacao(Conservacao conservacao) {
        this.conservacao = conservacao;
    }
}
