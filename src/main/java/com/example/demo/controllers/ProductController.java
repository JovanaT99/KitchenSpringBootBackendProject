package com.example.demo.controllers;

import com.example.demo.services.ProductServis;
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

    @Autowired
    public ProductController(ProductServis productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> allProduct() {
        return productService.findAllProduct();
    }

    @GetMapping("/id")
    public Optional<Product> getProductById(@RequestParam(name = "id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/name")
    public Optional<Product> getProductByName(@RequestParam(name = "name") String name) {
        return productService.getProductByNamee(name);
    }

    @PostMapping
    public void putNewIngredients(@RequestBody Product product) {
        productService.addNewIngredients(product);
    }

    @DeleteMapping(path = "/{productId}")
    public void deleteProduct(@PathVariable("productId") Long id) {
        productService.deleteProduct(id);
    }


    @PutMapping(path = "{id}")
    public void updateIngredientsByCurrentPrice(

            @PathVariable("id") Long id,
            @RequestParam(required = false) double currentprice) {

        productService.updateIngredients(id, currentprice);
    }



    @PutMapping(path = "/name/{id}")
    public void updateIngredientsByName(

            @PathVariable("id") Long id,
            @RequestParam(required = false) String name) {

        productService.updateIngredientsByName(id, name);
    }


}
