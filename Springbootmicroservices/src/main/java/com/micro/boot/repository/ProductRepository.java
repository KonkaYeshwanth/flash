package com.micro.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.boot.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
