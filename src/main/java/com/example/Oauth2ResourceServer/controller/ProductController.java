package com.example.Oauth2ResourceServer.controller;

import com.example.Oauth2ResourceServer.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ProductController {

    private static List<Product> productList = new LinkedList<>(List.of(
            Product.builder().id("001").name("gpt-1").build(),
            Product.builder().id("002").name("gpt-2").build()
    ));

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProduct() {
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/product")
    public ResponseEntity<Void> getProduct(@RequestBody Product product) {
        productList.add(product);
        return ResponseEntity.ok().build();
    }
}