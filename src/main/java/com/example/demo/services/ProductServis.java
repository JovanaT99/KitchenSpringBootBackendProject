package com.example.demo.services;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServis {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServis(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }


    public Optional<Product> getProductByNamee(String name) {
        Optional<Product> productByName = productRepository.getProductByName(name);
        if (productByName.isEmpty()) {
            throw new IllegalStateException("Product with name doesnt exist");
        }
        return productRepository.getProductByName(name);
    }

    public Optional<Product> getProductById(Long id) {

        Optional<Product> productById = productRepository
                .findIngredientsById(id);

        if (productById.isEmpty()) {
            throw new IllegalStateException("Product with id doesnt exist");
        }
        return productRepository.findById(id);
    }


    public void addNewIngredients(Product product) {
        Optional<Product> ingredientByName = productRepository
                .findIngredientsByName(product.getName());
        product.setCurrentPrice(product.getCurrentPrice());

        if (ingredientByName.isPresent()) {
            throw new IllegalStateException("name taken");
        } else if (product.getCurrentPrice() < 1) {

            throw new IllegalStateException("Check price");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {

        boolean exists = productRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("product with id" + id + "does not exist");
        }
        productRepository.deleteById(id);

    }

   /* public List<Product> getProductByName(String name) {
        return getProductByName(name);
    }

    */

    @Transactional
    public void updateIngredients(Long id, double currentprice) {

        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalStateException("product with id" + id + "doesnt exist"));

        if (currentprice != 0) {
            product.setCurrentPrice(currentprice);
        }

    }

    @Transactional
    public void updateIngredientsByName(Long id, String name) {

        Product product2 = productRepository.findById(id).orElseThrow(() -> new IllegalStateException("product with id" + id + "doesnt exist"));

        if (name != null && name.length() > 0) {
            Optional<Product> productOptional = productRepository.findIngredientsByName(name);
            if (productOptional.isPresent()) {
                throw new IllegalStateException("name taken");
            }
            product2.setName(name);
        }
    }
}

