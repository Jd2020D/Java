package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.CategoryProduct;
@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

}
