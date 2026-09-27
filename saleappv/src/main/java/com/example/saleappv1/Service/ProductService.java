package com.example.saleappv1.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.service.registry.ImportHttpServices;

import com.example.saleappv1.Model.Product;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
@Service
public class ProductService {
	private final ObjectMapper objectMapper;
	public ProductService(ObjectMapper objectMapper) {
		this.objectMapper=objectMapper;
	}
	public List<Product> getProduct(){
		try {
			InputStream inputStream= getClass().getResourceAsStream("/data/products.json");
			
			return objectMapper.readValue(inputStream, new TypeReference<List<Product>>() {});
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ArrayList<Product>();
		}
	}
	public Product getProductByID(int id) {
		return getProduct()
				.stream()
				.filter( p -> p.getId() == id)
				.findFirst()
				.orElse(null);
	}
	
}
