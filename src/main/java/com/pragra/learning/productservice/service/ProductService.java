package com.pragra.learning.productservice.service;

import com.pragra.learning.productservice.entity.Categories;
import com.pragra.learning.productservice.entity.Products;
import com.pragra.learning.productservice.repository.CategoryRepository;
import com.pragra.learning.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Products> getAllProducts() { return productRepository.findAll(); }

    public List<Products> getAllProductsByCategory(Long id) { return productRepository.findByCategory_Id(id); }

    public Products createProduct(Products product) {
        Categories category = product.getCategory();
        Optional<Categories> existingCategory = categoryRepository.findByName(category.getName());

        if(existingCategory.isPresent()) category = existingCategory.get(); // use existing category.
        else category = categoryRepository.save(category); // save in db

        product.setCategory(category);
        return productRepository.save(product);
    }

    public Products updateProduct(Products product) {
        // pass id with both of them else it won't work
        categoryRepository.save(product.getCategory());
        return productRepository.save(product);
    }
    public Optional<Products> getProductById(Long id) { return productRepository.findById(id); }

    public Optional<Products> deleteProductById(Long id) {
        Optional<Products> productOptional = productRepository.findById(id);
        productRepository.deleteById(id);
        return productOptional;
    }

}
