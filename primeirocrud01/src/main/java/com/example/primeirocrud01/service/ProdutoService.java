package com.example.primeirocrud01.service;

import java.util.List;
import java.util.Optional;

import com.example.primeirocrud01.model.Produto;

public interface ProdutoService {
    
    Produto criarProduto(Produto produto);

    List<Produto> obterTodos();

    Optional<Produto> obterPorId(String id);

    void removerProduto(String id);

    Produto atualizarProduto(String id, Produto produto);
}
