package com.pragra.learning.productservice.service;

import com.pragra.learning.productservice.entity.Categories;
import com.pragra.learning.productservice.entity.Products;
import com.pragra.learning.productservice.repository.CategoryRepository;
import com.pragra.learning.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductService productService;

    public List<Categories> getAllCategories() { return categoryRepository.findAll(); }

    public Categories addOrUpdateCategory(Categories category) {
        // while updating, use id with json data
        return categoryRepository.save(category);
    }

    public boolean existByName(String categoryName) { return categoryRepository.existsByName(categoryName); }

    public Optional<Categories> getCategoryById(Long id) { return categoryRepository.findById(id); }

    public Optional<Categories> deleteCategoryById(Long id) {
        Optional<Categories> category = getCategoryById(id);
        List<Products> deleteProduct = productService.getAllProductsByCategory(id);
        System.out.println(deleteProduct);
        for (Products product : deleteProduct) {
            productService.deleteProductById(product.getId());
        }
        categoryRepository.deleteById(id);
        return category;
    }
}
