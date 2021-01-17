package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findByCategoriesNotContains(Category category);
//	@Query("select p from Product p where p.category.id<> :categoryId")
//	List<Product> othersProducts(@Param("categoryId") Long categoryId);

}
