package com.remtech.payment.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService{
	
@Autowired
private ProductRepo repository;

public ProductService() {
	super();
}
	    /*get products @GetMappping*/
	public List<Products> getProducts(){
		return repository.findAll();
	}
	/*post products @PostMappping*/
	public Products postProduct(Products product) {
		return repository.save(product);
	}
	
	/*put products @PutMappping*/
	public Products updateProductById(Products products,int id){
		if(repository.existsById(id)==true) {
			Products product=(Products)repository.findById(id).get();
			product.setProduct_colour(products.getProduct_colour());
			product.setProduct_date(products.getProduct_date());
			product.setProduct_name(products.getProduct_name());
			product.setProduct_price(products.getProduct_price());
			return repository.saveAndFlush(product);
		}else{
			return null;
		}
	}
	
	/*delete product by id @DeleteMapping*/
	public void deleteProductById(int id) {
		if(repository.existsById(id)==true) {
		     repository.deleteById(id);   /* to work on the return type here*/
		}
	}
	
	/* get product by id @GetMapping*/
	public Products getProductById(int id) {
		if(repository.existsById(id)) {
			return repository.findById(id).get();
		}
		else{
			return null;
		}
	}
}
