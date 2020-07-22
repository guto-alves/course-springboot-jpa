package com.gutotech.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gutotech.course.entities.Product;

public interface ProductRepository 
	extends JpaRepository<Product, Long>{

}
