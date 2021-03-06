package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Category;
import com.example.demo.models.CategoryProduct;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryProductRepository;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

@Service
public class AppService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final CategoryProductRepository categoryProductRepository;
	public AppService(ProductRepository productRepository, 
					  CategoryRepository categoryRepository,
					  CategoryProductRepository categoryProductRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.categoryProductRepository = categoryProductRepository;
	}
	public Product createProduct(Product product) {
		return this.productRepository.save(product);
	}
	public Category createCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
	public CategoryProduct createCategoryProduct(CategoryProduct categoryProduct) {
		return this.categoryProductRepository.save(categoryProduct);
	}
	public List<Category>othersCategories(Long productId){
		return this.categoryRepository.findByProductsNotContains(this.getProductById(productId));
	}
	public List<Product>othersProducts(Long categoryId){
		return this.productRepository.findByCategoriesNotContains(this.getCategoryById(categoryId));
	}
	public Product getProductById(Long id) {
		return this.productRepository.findById(id).orElse(null);
	}
	public Category getCategoryById(Long id) {
		return this.categoryRepository.findById(id).orElse(null);
	}
	public List<Category> allCategories(){
		return this.categoryRepository.findAll();
	}
		 
}
