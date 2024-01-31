package com.pragra.learning.productservice.controller;

import com.pragra.learning.productservice.entity.Products;
import com.pragra.learning.productservice.service.CategoryService;
import com.pragra.learning.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Products> getProducts() { return productService.getAllProducts(); }

    @PostMapping("/new")
    public Products addNewCategory(@RequestBody Products product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Optional<Products> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/update")
    public Products updateCategory(@RequestBody Products product) {
        return productService.updateProduct(product);
    }


    @DeleteMapping("/delete/{id}")
    public Optional<Products> deleteProduct(@PathVariable Long id) {
        return productService.deleteProductById(id);
    }
}
