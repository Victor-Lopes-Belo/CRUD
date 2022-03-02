package com.example.primeirocrud01.repository;

import com.example.primeirocrud01.model.Produto;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutosRepository extends MongoRepository<Produto, String> {
    
}
