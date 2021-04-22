package com.PWS.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PWS.demo.entity.Product;
import com.PWS.demo.repository.ProductRepository;

import java.util.*;

//import javax.print.attribute.standard.MediaSize.Other;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
		
	}
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
		
	}
	public List<Product> getProducts(){
		return repository.findAll();
	}
	public Product getProductById(int id){
		return repository.findById(id).orElse(null);
	}
	public Product getProductByName(String name){
		return repository.findByName(name);
	}
	public String deleteProduct(int id){
		repository.deleteById(id);
		return "deleted" +id;
		
	}
	public Product updateProduct(Product product) {
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
		
		
	}
	
}
