package com.example.new_proj.Model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    @Column(unique=true)
    private String categoryName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "category_join_product",
            joinColumns = @JoinColumn(name="categoryId"),
            inverseJoinColumns = @JoinColumn(name="productId")
    )

    private Collection<Product> product = new ArrayList<Product>();

    public Category(){
        super();
    }

    public Category(int categoryId, String categoryName, Collection<Product> product) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.product = product;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
