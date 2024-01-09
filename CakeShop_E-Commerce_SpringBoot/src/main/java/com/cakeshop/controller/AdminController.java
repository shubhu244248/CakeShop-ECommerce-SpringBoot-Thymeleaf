package com.cakeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminController {
	
	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
	}
	
	@GetMapping("/admin/categories")
	public String getCategories() {
		return "categories";
	}
	
}
