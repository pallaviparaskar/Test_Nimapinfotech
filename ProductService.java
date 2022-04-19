package com.example.new_proj.Service;

import com.example.new_proj.Model.Product;
import com.example.new_proj.Repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }


    public StringBuilder getAllProducts() {

        StringBuilder products = new StringBuilder();

        List<Product> products1 = productRepository.findAll();
        products1.stream().forEach(product -> products.append(product.getProductId()
                + " " + product.getProductName() + " \n"));
        return products;
    }


    public String addProduct(Product product) {
        productRepository.save(product);
        return "Product Added Succesfully";
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product Deleted successfully ";
    }

    public String updateProductName(int id, String productName) {
        Product product = productRepository.getById(id);
        product.setProductName(productName);
        productRepository.save(product);
        return "Products name updated successfully";
    }
}
