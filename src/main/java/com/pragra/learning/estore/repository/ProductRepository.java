package com.pragra.learning.estore.repository;

import com.pragra.learning.estore.enitities.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductData,Long> {
}
