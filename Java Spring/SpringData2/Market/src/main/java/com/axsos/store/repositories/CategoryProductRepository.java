package com.axsos.store.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.store.models.CategoryProduct;
@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

}
