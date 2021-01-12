package com.axsos.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axsos.store.models.Category;
import com.axsos.store.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findByCategoriesNotContains(Category category);

//	@Query("select p from Product p where p.category.id<> :categoryId")
//	List<Product> othersProducts(@Param("categoryId") Long categoryId);

}
