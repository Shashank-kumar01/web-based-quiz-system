package com.shashank.quizsystem.controller;

import com.shashank.quizsystem.entity.Category;
import com.shashank.quizsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public String addCategory(@RequestBody Category category) {

        return categoryService.addCategory(category);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {

        return categoryService.getAllCategories();
    }
    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable Long id) {

        return categoryService.deleteCategory(id);
    }

    @PutMapping("/category/{id}")
    public String updateCategory(@PathVariable Long id,
                                 @RequestBody Category category) {

        return categoryService.updateCategory(id, category);
    }
    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
}