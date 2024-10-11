package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.dto.CategoryListResponseDTO;
import com.scaler.ecomproductservice.dto.CategoryResponseDTO;
import com.scaler.ecomproductservice.exceptions.CategoryNotFoundException;
import com.scaler.ecomproductservice.mapper.CategoryMapper;
import com.scaler.ecomproductservice.models.Category;
import com.scaler.ecomproductservice.repositories.CategoryRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@Service
public class CategoryService
{

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(String categoryName)
    {
        // Create Category object

        Category category = new Category();
        category.setCategoryName(categoryName);
        return this.categoryRepository.save(category);
    }

    public CategoryListResponseDTO getAllCategories()
    {
        List<Category> categoryList = this.categoryRepository.findAll();
        return CategoryMapper.convertCategoryListToCategoryListResponseDTO(categoryList);
    }

    public CategoryResponseDTO findCategoryById(UUID id) throws CategoryNotFoundException
    {
        Optional<Category> category = this.categoryRepository.findById(id);
        if(category.isPresent())
            return CategoryMapper.convertCategoryToCategoryResponseDTO(category.get());
        else
            throw new CategoryNotFoundException("Category with "+id +" is not found");

    }
}
