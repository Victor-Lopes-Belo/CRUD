package com.example.primeirocrud01.service;

import java.util.List;
import java.util.Optional;

import com.example.primeirocrud01.model.Produto;
import com.example.primeirocrud01.repository.ProdutosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpel implements ProdutoService {

    @Autowired
    private ProdutosRepository repositorio;
    
    @Override
    public Produto criarProduto(Produto produto) {
        return repositorio.save(produto);
    }

    @Override
    public List<Produto> obterTodos() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Produto> obterPorId(String id) {
        return repositorio.findById(id);
    }

    @Override
    public void removerProduto(String id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public Produto atualizarProduto(String id, Produto produto) {
        produto.setId(id);
        return repositorio.save(produto);
    }
    
}
