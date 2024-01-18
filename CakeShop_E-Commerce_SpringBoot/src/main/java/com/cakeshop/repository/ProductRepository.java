package com.cakeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cakeshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
