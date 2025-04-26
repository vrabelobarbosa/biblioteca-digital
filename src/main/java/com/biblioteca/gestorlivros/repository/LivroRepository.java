package com.biblioteca.gestorlivros.repository;

import com.biblioteca.gestorlivros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interface que gerencia o acesso aos dados (banco de dados)
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // JpaRepository já dá todos os métodos prontos: salvar, buscar, listar e deletar
}
