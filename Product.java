package com.example.new_proj.Model;

import javax.persistence.*;

@Entity
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @Column(unique=true)
    private String productName;

    @ManyToOne
    private Category category;
    public  Product (){
        super();
    }
    public Product(int productId, String productName, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
