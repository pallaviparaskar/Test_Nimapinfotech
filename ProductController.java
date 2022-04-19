package com.example.new_proj.Controller;

import com.example.new_proj.Model.Category;
import com.example.new_proj.Model.Product;
import com.example.new_proj.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    //1
    @GetMapping("/products?page=2")
    public StringBuilder getAllProducts() {
        return productService.getAllProducts();
    }

    //2
    @PostMapping("/products")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    //3
    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable int id){
        return  productService.getProductById(id);
    }

    //4

    @PutMapping("/products/{id}")
    public String updateProductName(@PathVariable ("id") int id,@RequestBody String productName) {
        return productService.updateProductName(id, productName);
    }

    //5
    @DeleteMapping("/products/{id}")
    public String addCategory(@PathVariable int id){
        return productService.deleteProduct(id);
    }

}
