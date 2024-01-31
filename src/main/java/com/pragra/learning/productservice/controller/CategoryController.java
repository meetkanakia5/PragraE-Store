package com.pragra.learning.productservice.controller;

import com.pragra.learning.productservice.entity.Categories;
import com.pragra.learning.productservice.entity.Products;
import com.pragra.learning.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Categories> getCategories() { return categoryService.getAllCategories(); }

    @PostMapping("/new")
    public Categories addNewCategory(@RequestBody Categories category) { return categoryService.addOrUpdateCategory(category); }

    @PutMapping("/update")
    public Categories updateCategory(@RequestBody Categories category) { /*while updating, use id with json data*/ return categoryService.addOrUpdateCategory(category); }

    @GetMapping("/{id}")
    public Optional<Categories> getCategoriesById(@PathVariable Long id) { return categoryService.getCategoryById(id); }

    @DeleteMapping("/delete/{id}")
    public Optional<Categories> deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategoryById(id);
    }
}
