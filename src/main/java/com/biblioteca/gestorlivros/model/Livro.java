package com.biblioteca.gestorlivros.model;

import jakarta.persistence.*;

// Classe que representa a tabela "livros" no banco de dados
@Entity
@Table(name = "livros")
public class Livro {

    @Id // Identificador único de cada livro
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Banco gera o ID automaticamente
    private Long id;

    @Column(nullable = false) // Campo obrigatório no banco
    private String titulo;

    @Column(nullable = false) // Campo obrigatório
    private String autor;

    @Column(nullable = false) // Campo obrigatório
    private Integer anoPublicacao;

    @Column(nullable = false, unique = true) // ISBN não pode repetir
    private String isbn;

    // Métodos Getters e Setters para acessar e modificar os atributos

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }

    public void setAutor(String autor) { this.autor = autor; }

    public Integer getAnoPublicacao() { return anoPublicacao; }

    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }
}
