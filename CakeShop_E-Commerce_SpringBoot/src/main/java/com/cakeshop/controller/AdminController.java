package com.cakeshop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cakeshop.model.Category;
import com.cakeshop.service.CategoryService;
import com.cakeshop.service.ProductService;

@Controller
public class AdminController {
	
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
	}

	@GetMapping("/admin/categories")
	public String getCat(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "categories";
	}
	

	@GetMapping("/admin/categories/add")
	public String getCatdAdd(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}

	@PostMapping("/admin/categories/add")
	public String postCatAdd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCat(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}
	
	
	@GetMapping("/admin/categories/update/{id}")
	public String updateCat(@PathVariable int id, Model model) {
		Optional<Category> optional = categoryService.getCategoryById(id);
		if(optional.isPresent()) {
			model.addAttribute("category",optional.get());
			return "categoriesAdd";
		} else {
			return "404";
		}
	}
	
	
//	Product Section

	@GetMapping("/admin/products")
	public String getProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	
	
	
}
