 package com.remtech.payment.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/product")
public class ProductController {
	
/* class to control the requests*/
/* ResponseEntity */
	
	@Autowired
	private ProductService proService;
	
	@GetMapping("/") /*GETS all products*/
	public List<Products> getProducts(){
		return proService.getProducts();
	}
	
	@PostMapping("/") /*POSTS the entity*/
	public ResponseEntity<Products> postProducts(@RequestBody Products product){
		Products pro=proService.postProduct(product);
		if(pro!=null) {
			return new ResponseEntity<Products>(pro,HttpStatus.CREATED);
		}
		else{
			return new ResponseEntity<Products>(pro,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}") /* UPDATES the entity*/
	public ResponseEntity<Object> updateProduct(@RequestBody Products product,@PathVariable int id){
		Products products=proService.updateProductById(product, id);
		if(products!=null) {
			return new ResponseEntity<Object>(products,HttpStatus.ACCEPTED);
		} 
		else {
			return new ResponseEntity<Object>("Not Updated",HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	@DeleteMapping("/{id}") /* DELETES the specified entity*/
	public ResponseEntity<Object> deleteById(@PathVariable int id){
		
		return new ResponseEntity<Object>(HttpStatus.OK); /*temp place holder*/
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Products> getProductsById(@PathVariable int id){
		Products product=proService.getProductById(id);
		if(product!=null) {
			return new ResponseEntity<Products>(product,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Products>(product,HttpStatus.NOT_FOUND);
	}
}
}
