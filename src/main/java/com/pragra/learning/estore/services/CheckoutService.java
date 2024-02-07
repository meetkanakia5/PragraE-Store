package com.pragra.learning.estore.services;

import com.pragra.learning.estore.enitities.ProductData;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service

public class CheckoutService {



        @Value("${url}")
        private String yourDomain;

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @Autowired
    private ProductService productService;

        public String createCheckoutSession(Long id) throws StripeException {
            Stripe.apiKey = stripeApiKey;

            ProductData productbase = productService.getProductById(id);
            if (productbase == null) {
                throw new RuntimeException("Product not found");
            }


            SessionCreateParams params = SessionCreateParams.builder()
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl(yourDomain + "/success")
                    .setCancelUrl(yourDomain + "/cancel")
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()

                                    .setPrice(productbase.getProductId()) // Amount in cents
                                     // Replace with your product's currency

                                    .build())
                    .build();

            Session session = Session.create(params);

            return "redirect:" + session.getUrl();
        }
    }


