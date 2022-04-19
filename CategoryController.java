package com.example.new_proj.Controller;

import com.example.new_proj.Model.Category;
import com.example.new_proj.Model.Product;
import com.example.new_proj.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //1
    @GetMapping("/categories?page=3")
    public StringBuilder getAllCategories() {
        return categoryService.getAllCategories();
    }
    //2

    @PostMapping("/categories")
    public String addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
    //3
    @GetMapping("/category/{id}")
    public Optional<Category> getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    //4
    @PutMapping("/categories/{id}")
    public String updatecategoryName(@PathVariable ("id") int id,@RequestBody String categoryName) {
        return categoryService.updateCategoryName(id, categoryName);
    }

    //5
    @DeleteMapping("/categories/{id}")
    public String deleteCategory(@PathVariable int id){
        return categoryService.deleteCategory(id);
    }

}
