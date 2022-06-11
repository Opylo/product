package com.optimartnetcom.productapi.controller;

import com.optimartnetcom.productapi.model.Product;
import com.optimartnetcom.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id){
        return productRepository.findById(id).get();
    }

    //@RequestMapping(value = "/products/", method = RequestMethod.POST)
    @PostMapping("/products")
    public List<Product> createProduct(@RequestBody List<Product> product){
        return productRepository.saveAll(product);
    }

    @PutMapping(value = "/products/{id}")
    public List<Product> updateProduct(@PathVariable("id") int id, @RequestBody List<Product> product){
        return productRepository.saveAll(product);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int id) {
        productRepository.deleteById(id);
    }
}
