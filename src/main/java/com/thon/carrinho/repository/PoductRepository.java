package com.thon.carrinho.repository;


import com.thon.carrinho.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoductRepository extends JpaRepository<Product, Long> {
}
