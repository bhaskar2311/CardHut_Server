package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Product;

@Repository()
public class ProductDaoImpl implements ProductDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Product addOrUpdateProduct(Product product) {
		Product addProduct=em.merge(product);
		return addProduct;
	}

	public Product getProductById(int productId) {
		return em.find(Product.class, productId);
	}

	public List<Product> viewAllProducts() {
		return em.createQuery("select p from Product p", Product.class).getResultList();
	}

}
