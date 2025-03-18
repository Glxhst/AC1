package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaRepository {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public Categoria salvar(Categoria categoria) {
        return entityManager.merge(categoria);
    }

    public List<Categoria> obterTodos() {
        return entityManager.createQuery("FROM Categoria", Categoria.class).getResultList();
    }
        public Categoria obterPorId(Long id) {
        return entityManager.find(Categoria.class, id);
    }
   
}
