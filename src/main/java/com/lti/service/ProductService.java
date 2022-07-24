package com.lti.service;

import java.util.List;

import com.lti.entity.Product;

public interface ProductService {
	String addProduct(Product product);
	String findProduct(int productId);
	List<Product> viewProducts();
}
