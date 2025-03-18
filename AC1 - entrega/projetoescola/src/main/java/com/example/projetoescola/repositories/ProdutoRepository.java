package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto salvar(Produto Produto) {
        return entityManager.merge(Produto);
    }

    public List<Produto> obterTodos() {
        return entityManager.createQuery("from Produto", Produto.class)
                .getResultList();
    }
    public Produto obterPorId(Long id) {
        return entityManager.find(Produto.class, id);
    }
    

}
