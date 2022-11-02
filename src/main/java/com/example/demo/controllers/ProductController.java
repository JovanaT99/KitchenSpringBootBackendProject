package com.example.demo.controllers;

import com.example.demo.Services.ProductServis;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/ingredients")
public class ProductController {

    private final ProductServis productService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductServis productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public List<Product> allProduct(){
        return productService.findAllProduct();
    }

    @GetMapping("/id")
    public Optional<Product> getProductById(@RequestParam(name = "id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/name")
    public Optional<Product> getProductByName(@RequestParam(name = "name") String name){
        return productRepository.getProductByName(name);
   }

    @PostMapping
    public void putNewIngredients(@RequestBody Product product){
        productService.addNewIngredients(product);
    }

    @DeleteMapping(path = "/{productId}")
    public void deleteProduct(@PathVariable("productId") Long id){
        productService.deleteProduct(id);
    }











}
