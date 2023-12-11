package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private final ProductService productService;
	

	public ProductController(ProductService productService) {
		this.productService= productService;
	}
	@GetMapping("/all")
	public List<Map<String,Object>> getAllProduct(){
		return productService.getAllProduct();
	}
	@GetMapping("/byId/{id}")
	public Map<String,Object> getProductById(@PathVariable("id")int id){
		return productService.getProductById(id);
	}
	@PostMapping("/insert")
	public String insertProduct(@RequestBody Map<String,Object> prod) {
		return productService.insertProduct(prod);
	}
	@PutMapping("/update")
	public String updateProduct(@RequestBody Map<String,Object> prod) {
		return productService.updateProduct(prod);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id")int id) {
		return productService.deleteProduct(id);
	}
}
