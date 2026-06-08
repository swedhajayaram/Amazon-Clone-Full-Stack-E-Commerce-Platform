package com.example.amazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.amazon.entity.*;
import com.example.amazon.dao.*;
import java.util.*;

@Service
public class ProductService {

	@Autowired
	ProductRepo pr;
	
	public void productsave(Product p)
	{
		pr.save(p);
	}
	
	public Product productupdate(Product p)
	{
		return pr.save(p);
	}
	
	public List<Product> productselect()
	{
		return pr.findAll();
	}
	
	public Product productparticular(int id)
	{
		Optional<Product> pro=pr.findById(id);
		return pro.orElse(null);
	}
	
	public void productdelete(int id)//1
	{
		pr.deleteById(id);
	}
	
	
}
