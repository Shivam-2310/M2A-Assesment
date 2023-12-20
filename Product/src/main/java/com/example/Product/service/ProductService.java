package com.example.Product.service;

import com.example.Product.model.Product;
import com.example.Product.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProductWithImage(String name, String description, double price, int quantity, String manufacturer, MultipartFile file) {
        try {
            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setManufacturer(manufacturer);
            product.setImage(file.getBytes());
            productRepository.save(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
