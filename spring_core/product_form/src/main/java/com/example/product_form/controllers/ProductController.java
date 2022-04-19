package com.example.product_form.controllers;

import com.example.product_form.models.Product;
import com.example.product_form.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public String addProduct(
        @RequestParam String name,
        @RequestParam double price,
        Model model
    ) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        this.productService.addProduct(p);

        var products = this.productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = this.productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}
