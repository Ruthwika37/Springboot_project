package com.example.demo.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private final ProductRepo productRepo;
	

	public ProductService(ProductRepo productRepo) {
		super();
		this.productRepo = productRepo;
	}
	public List<Map<String,Object>> getAllProduct(){
		return productRepo.getAllProduct();
	}
	public Map<String,Object> getProductById(int id){
		return productRepo.getProductById(id);
	}
	public String insertProduct(Map<String,Object> prod) {
		productRepo.insertProduct(prod);
		return "Insertion Success";
	}
	public String updateProduct(Map<String,Object> prod) {
		productRepo.updateProduct(prod);
		return "Updation Success";
	}
	public String deleteProduct(int id) {
		productRepo.deleteProduct(id);
		return "Deletion Success";
	}

}