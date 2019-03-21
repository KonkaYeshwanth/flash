package com.micro.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.micro.boot.model.Product;
import com.micro.boot.repository.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
         
	}

}
