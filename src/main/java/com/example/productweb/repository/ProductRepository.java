package com.example.productweb.repository;

import com.example.productweb.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findAllByName(String name);
//    List<Product> findAllByNameAndPrice(String name, Long price);
//    List<Product> findAllByPriceGreaterThan(Long price);
//    List<Product> findAllByPriceBetween(Long start, Long end, Pageable pageable);
}
