package com.example.Product.controller;

import com.example.Product.model.Product;
import com.example.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product-form")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/upload")
    public String handleFileUpload(
            @ModelAttribute Product product,
            @RequestParam("imageFile") MultipartFile file) {

        productService.saveProductWithImage(product.getName(), product.getDescription(),
                product.getPrice(), product.getQuantity(), product.getManufacturer(), file);
        System.out.println("File upload handled successfully.");

        return "redirect:/products";
    }

    @GetMapping("/products")
    public String showAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list";
    }
}
