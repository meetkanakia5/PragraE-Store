package com.pragra.learning.estore.services;

import com.pragra.learning.estore.enitities.ProductData;
import com.pragra.learning.estore.repository.ProductRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Value("${stripe.api.key}")
    private String stripeApiKey;



    public List<ProductData> getAllProducts() {
        return productRepository.findAll();
    }

        public ProductData createProduct(ProductData product) {
            return productRepository.save(product);
    }


    public ProductData getProductById(Long id) {
        Optional<ProductData> product = productRepository.findById(id);
        return product.get();

    }


    // Other methods for CRUD operations on products
}
