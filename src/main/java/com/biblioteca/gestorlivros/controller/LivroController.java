package com.biblioteca.gestorlivros.controller;

import com.biblioteca.gestorlivros.model.Livro;
import com.biblioteca.gestorlivros.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controller que cuida das requisições relacionadas aos livros
@RestController
@RequestMapping("/livros") // Prefixo das rotas
public class LivroController {

    private final LivroService service;

    // Construtor para injetar o LivroService
    public LivroController(LivroService service) {
        this.service = service;
    }

    // Cadastrar novo livro
    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        Livro novoLivro = service.salvar(livro);
        return ResponseEntity.ok(novoLivro); // Retorna o livro salvo com status 200
    }

    // Listar todos os livros
    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos() {
        List<Livro> livros = service.listarLivros();
        return ResponseEntity.ok(livros); // Retorna a lista de livros
    }

    // Buscar um livro pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        Optional<Livro> livro = service.buscarPorId(id);
        return livro.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Se não achar, retorna 404
    }

    // Atualizar um livro pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        Livro livro = service.atualizar(id, livroAtualizado);
        return ResponseEntity.ok(livro); // Retorna o livro atualizado
    }

    // Deletar um livro pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 (sem conteúdo)
    }
}
