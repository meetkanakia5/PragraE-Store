package com.pragra.learning.productservice.repository;

import com.pragra.learning.productservice.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
    boolean existsByName(String name);

    Optional<Categories> findByName(String name);
}
