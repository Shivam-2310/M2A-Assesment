package com.example.Product.controller;

import com.example.Product.model.Product;
import com.example.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class BarcodeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/barcode/{productId}")
    public String showBarcode(@PathVariable Long productId, Model model) {
        Optional<Product> product = Optional.ofNullable(productService.getProductById(productId));
        model.addAttribute("product", product);
        return "barcode";
    }
}

