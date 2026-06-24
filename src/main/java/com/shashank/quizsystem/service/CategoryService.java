package com.shashank.quizsystem.service;

import com.shashank.quizsystem.entity.Category;
import com.shashank.quizsystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public String addCategory(Category category) {

        categoryRepository.save(category);

        return "Category Added Successfully";
    }

    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }
    public String deleteCategory(Long id) {

        categoryRepository.deleteById(id);

        return "Category Deleted Successfully";
    }

    public String updateCategory(Long id, Category updatedCategory) {

        Category category = categoryRepository.findById(id).orElse(null);

        if(category != null) {

            category.setName(updatedCategory.getName());

            categoryRepository.save(category);

            return "Category Updated Successfully";
        }

        return "Category Not Found";
    }
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}