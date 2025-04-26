package com.biblioteca.gestorlivros.service;

import com.biblioteca.gestorlivros.model.Livro;
import com.biblioteca.gestorlivros.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Camada que cuida das regras de negócio (serviços relacionados a Livro)
@Service
public class LivroService {

    private final LivroRepository repo;

    // Construtor para injetar o repositório
    public LivroService(LivroRepository repo) {
        this.repo = repo;
    }

    // Método para salvar um novo livro
    public Livro salvar(Livro livro) {
        return repo.save(livro);
    }

    // Método para listar todos os livros
    public List<Livro> listarLivros() {
        return repo.findAll();
    }

    // Método para buscar um livro pelo ID
    public Optional<Livro> buscarPorId(Long id) {
        return repo.findById(id);
    }

    // Método para atualizar um livro
    public Livro atualizar(Long id, Livro dados) {
        dados.setId(id); // Garante que vamos atualizar o livro certo
        return repo.save(dados);
    }

    // Método para deletar um livro
    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
