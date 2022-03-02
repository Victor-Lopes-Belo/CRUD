package com.example.primeirocrud01.controller;

import java.util.Optional;

import com.example.primeirocrud01.model.Produto;
import com.example.primeirocrud01.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService servicos;

    @GetMapping
    public ResponseEntity obterProdutos() {
        return new ResponseEntity(servicos.obterTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Produto> obterPorId(@PathVariable String id) {
        Optional<Produto> produto = servicos.obterPorId(id);

        if(produto.isPresent()) {
            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity criarProduto(@RequestBody Produto produto) {
        return new ResponseEntity<>(servicos.criarProduto(produto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> removerProduto(@PathVariable String id) {
        servicos.removerProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "{id}")
    public Produto atualizarProduto(@PathVariable String id, @RequestBody Produto produto) {
        return servicos.atualizarProduto(id, produto);
    }
}
