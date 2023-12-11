package com.example.demo.Repo;
//Importing List 
import java.util.List;
//Importing Map
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//Repository annotation indicates that this class is a Data Access Object 
@Repository
public class ProductRepo {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	
	public ProductRepo(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//Method to get all values in product
	public List<Map<String,Object>> getAllProduct(){
		return jdbcTemplate.queryForList("select * from product");
	}
	
	//Method to get product details by using id
	public Map<String,Object> getProductById(int id){
		return jdbcTemplate.queryForMap("select * from product where id=?",id);
	}
	
	//Method to insert data in product table
	public void insertProduct(Map<String,Object> prod) {
		jdbcTemplate.update("insert into product values(?,?,?,?)",prod.get("id"),prod.get("name"),prod.get("price"),prod.get("quant"));
	}
	
	//Method to update product table
	public void updateProduct(Map<String,Object> prod) {
		jdbcTemplate.update("update product set name=?,price=?,quant=? where id=?",prod.get("name"),prod.get("price"),prod.get("quant"),prod.get("id"));
	}
	
	//Method to delete a  row in product based on id
	public void deleteProduct(int id) {
		jdbcTemplate.update("delete from product where id =?",id);
	}
}