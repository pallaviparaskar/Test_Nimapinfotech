package com.example.new_proj.Service;

import com.example.new_proj.Model.Category;
import com.example.new_proj.Model.Product;
import com.example.new_proj.Repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Optional<Category> getCategoryById(int id) {
        return  categoryRepository.findById(id);
    }

    public StringBuilder getAllCategories() {
        StringBuilder categories = new StringBuilder();

        List<Category> categories1 = categoryRepository.findAll();
        categories1.stream().forEach(category -> categories.append(category.getCategoryId()
                + " " + category.getCategoryName() + " \n"));
        return categories;
    }


    public String addCategory(Category category) {
        categoryRepository.save(category);
        return "Category Added Succesfully";
    }

    public String deleteCategory(int id) {
        categoryRepository.deleteById(id);
        return "Category Deleted successfully";
    }

    public String updateCategoryName(int id, String categoryName) {
        Category category = categoryRepository.getById(id);
        category.setCategoryName(categoryName);
        categoryRepository.save(category);
        return "Category name updated successfully";
    }
}
