package com.example.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.amazon.entity.*;
import com.example.amazon.service.*;


@Controller
public class ProductController {

	@Autowired
	ProductService ps;
	
	@GetMapping("/home")
	public String get1()
	{
		return "index";
	}
	
	@PostMapping("abc")
	public String get2(Product p)
	{
		ps.productsave(p);
		return "redirect:/select";
	}
	
	
	@GetMapping("/edit/{id}")
	public String get6(@PathVariable int id,Model m)
	{
		m.addAttribute("pro",ps.productparticular(id));
		return "productedit";
	}
	
	@PostMapping("/xyz")
	public String get7(Product p)
	{
		ps.productupdate(p);
		return "redirect:/select";
	}
	
	
	@GetMapping("/select")
	public String get3(Model m)
	{
		m.addAttribute("pro",ps.productselect());
		return "productview";
	}
	
	@GetMapping("/part/{id}")
	public String get4(@PathVariable int id,Model m)
	{
		m.addAttribute("pro",ps.productparticular(id));
		return "productview1";
	}
	
	@GetMapping("/delete/{id}")
	public String get5(@PathVariable int id)
	{
		ps.productdelete(id);
		return "redirect:/select";
		
	}
	
	
}


