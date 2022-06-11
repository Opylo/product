package com.optimartnetcom.productapi.repository;

import com.optimartnetcom.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
