package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    Optional<Product> findIngredientsById(Long id);

    @Query("SELECT s From Product s  Where s.name=?1")
    Optional<Product> findIngredientsByName(String name);

    @Query("SELECT h FROM Product h WHERE h.name=?1")
    Optional<Product> getProductByName(String name);



}
