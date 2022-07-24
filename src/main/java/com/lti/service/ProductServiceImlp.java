package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lti.dao.ProductDao;
import com.lti.entity.Product;

@Service("ProductService")
public class ProductServiceImlp implements ProductService {
	@Autowired
	ProductDao productDao;
	
	public String addProduct(Product product) {
		try {
			Product product2=productDao.addOrUpdateProduct(product);
			return "Product Added Successfully.";
		} catch (Exception e) {
			return "Error Occured While Adding Product";
		}
	}

	public String findProduct(int productId) {
		try {
			Product product2=productDao.getProductById(productId);
			return "Product Name: "+product2.getProductName()+"Product Price: "+product2.getProductCost()+"Product Description : "+product2.getProductDescription();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public List<Product> viewProducts() {
		List<Product> product2=productDao.viewAllProducts();
		return product2;
	}

}
