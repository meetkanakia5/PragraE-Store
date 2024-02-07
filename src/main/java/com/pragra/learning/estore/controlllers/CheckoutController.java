package com.pragra.learning.estore.controlllers;

//import com.stripe.sample.service.CheckoutService;
import com.pragra.learning.estore.enitities.ProductData;
import com.pragra.learning.estore.services.CheckoutService;
import com.pragra.learning.estore.services.ProductService;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;
    @Autowired
    private ProductService productService;


    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/create-checkout-session")
    public String createCheckoutSession(@RequestParam Long id) throws StripeException {
        return checkoutService.createCheckoutSession(id);
    }

    @GetMapping("/products")
    public List<ProductData> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/success")
    public String checkoutSuccess() {
        return "Payment successful!";
    }

    @GetMapping("/cancel")
    public String checkoutCancel() {
        return "Payment canceled!";
    }

    @PostMapping("/create-product")
    public ResponseEntity<String> createProduct(@RequestBody ProductData product) throws StripeException {

            ProductData savedProduct = productService.createProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product created with ID: " + savedProduct.getId());
        }



}