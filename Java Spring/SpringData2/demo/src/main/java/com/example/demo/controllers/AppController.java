package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Category;
import com.example.demo.models.CategoryProduct;
import com.example.demo.models.Product;
import com.example.demo.services.AppService;

@Controller
public class AppController {
	 private final AppService appService;

	public AppController(AppService appService) {
		this.appService = appService;
	}
	 @RequestMapping("products/new")
	 public String viewNew(@ModelAttribute("product") Product dojo) {
	     return "newProduct.jsp";
	 }
	 @RequestMapping("categories/new")
	 public String viewNew(@ModelAttribute("category") Category category) {
	     return "newCategory.jsp";
	 }
	 @RequestMapping(value="/products/new", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
	     if (result.hasErrors()) {
	         return "newProduct.jsp";
	     } else {
	         this.appService.createProduct(product);
	         return "redirect:/products/"+product.getId().toString();
	     }
	 }
	 @RequestMapping(value="/categories/new", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
	     if (result.hasErrors()) {
	         return "newCategory.jsp";
	     } else {
	         this.appService.createCategory(category);
	         return "redirect:/categories/"+category.getId().toString();
	     }
	 }
	 @RequestMapping("/products/{id}")
	 public String showProduct(@PathVariable Long id ,Model model, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct) {
		 Product product=this.appService.getProductById(id);
		 if (product==null)
			 return "redirect:/products/new";
	     model.addAttribute("pro", product);
	     model.addAttribute("othersCats",this.appService.othersCategories(id));
	     return "productPage.jsp";
	 }
	 
	 @RequestMapping(value="/products/{id}", method=RequestMethod.POST)
	 public String addCategory(@PathVariable Long id ,Model model, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct, BindingResult result) {
		 Product product=this.appService.getProductById(id);
		 if (product==null)
			 return "redirect:/products/new";
		 if(categoryProduct.getCategory()==null||categoryProduct.getProduct()==null)
	    	 return "redirect:/products/"+id.toString();
	     model.addAttribute("pro", product);
	     model.addAttribute("othersCats",this.appService.othersCategories(id));
	     if(result.hasErrors())
	    	 return "productPage.jsp";
	     else {
	    	 this.appService.createCategoryProduct(categoryProduct);
	    	 return "redirect:/products/"+id.toString();
	     }
	 }
	 
	 @RequestMapping("/categories/{id}")
	 public String showCat(@PathVariable Long id ,Model model, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct) {
		 Category category=this.appService.getCategoryById(id);
		 if (category==null)
			 return "redirect:/categories/new";
	     model.addAttribute("cat", category);
	     model.addAttribute("othersProducts",this.appService.othersProducts(id));
		 return "categoryPage.jsp";
	 }

	 @RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
	 public String addProduct(@PathVariable Long id ,Model model,@ModelAttribute("categoryProduct") CategoryProduct categoryProduct, BindingResult result) {
		 Category category=this.appService.getCategoryById(id);
		 if (category==null)
			 return "redirect:/categories/new";
		 
		 if(categoryProduct.getCategory()==null||categoryProduct.getProduct()==null)
	    	 return "redirect:/categories/"+id.toString();
		 model.addAttribute("cat", category);
	     model.addAttribute("othersProducts",this.appService.othersProducts(id));
	     if(result.hasErrors())
		     return "categoryPage.jsp";
	     else {
	    	 this.appService.createCategoryProduct(categoryProduct);
	    	 return "redirect:/categories/"+id.toString();
 
	     }
	 }


}
