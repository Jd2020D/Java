package com.example.demo.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

//...
@Entity
@Table(name="categories_products")
public class CategoryProduct {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date createdAt;
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date updatedAt;
	@PrePersist
 protected void onCreate(){
     this.createdAt = new Date();
 }
	@PreUpdate
 protected void onUpdate(){
     this.updatedAt = new Date();
 }
 @NotNull
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="product_id")
 private Product product;
 @NotNull
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="category_id")
 private Category category;
 
 public CategoryProduct() {
     
 }
public CategoryProduct(Product product, Category category) {
	this.product = product;
	this.category = category;
}
public Product getProduct() {
	return product;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}
public void setProduct(Product product) {
	this.product = product;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public Long getId() {
	return id;
}
public Date getCreatedAt() {
	return createdAt;
}
public Date getUpdatedAt() {
	return updatedAt;
}
 
}
