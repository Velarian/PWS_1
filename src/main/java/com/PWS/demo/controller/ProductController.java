package com.PWS.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PWS.demo.entity.Product;
import com.PWS.demo.service.ProductService;
@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
		
	}
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
		
	} 
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return service.getProducts();
		
	} 
	@GetMapping("/productById/{id}")//ambiguous error coz #1 having product as a url
	public Product finProductById(@PathVariable int id) {
		return service.getProductById(id);	
	}
	@GetMapping("/product/{name}")//#1
	public Product finProductByName(@PathVariable String name) {
		return service.getProductByName(name);	
	}
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct (product);
		
	} 
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
		
	}
}
