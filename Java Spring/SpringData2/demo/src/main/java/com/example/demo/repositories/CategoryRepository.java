package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Category;
import com.example.demo.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
//@Query("select c from Category c where c.product.id<> :productId")
//List<Category> othersCategories(@Param("productId")Long productId);
	List<Category> findByProductsNotContains(Product product);
	List<Category> findAll();
	find
}
