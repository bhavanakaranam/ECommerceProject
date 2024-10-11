package com.scaler.ecomproductservice.controller;

import com.scaler.ecomproductservice.dto.CategoryListResponseDTO;
import com.scaler.ecomproductservice.dto.CategoryRequestDTO;
import com.scaler.ecomproductservice.dto.CategoryResponseDTO;
import com.scaler.ecomproductservice.exceptions.CategoryNotFoundException;
import com.scaler.ecomproductservice.exceptions.CouldNotCreateCategoryException;
import com.scaler.ecomproductservice.exceptions.InvalidCategoryNameException;
import com.scaler.ecomproductservice.mapper.CategoryMapper;
import com.scaler.ecomproductservice.models.BaseModel;
import com.scaler.ecomproductservice.models.Category;
import com.scaler.ecomproductservice.service.CategoryService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Controller
public class CategoryController
{
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity findCategoryById(@PathVariable("id") UUID id) throws CategoryNotFoundException
    {
        CategoryResponseDTO categoryResponseDTO = this.categoryService.findCategoryById(id);
        return ResponseEntity.ok(categoryResponseDTO);
    }

    @GetMapping("/category")
    private ResponseEntity findAllCategories()
    {
        CategoryListResponseDTO categoryList = this.categoryService.getAllCategories();
        return ResponseEntity.ok(categoryList);
    }

    @PostMapping("/category/createcategory")
    private ResponseEntity createCategory(CategoryRequestDTO categoryRequestDTO) throws InvalidCategoryNameException, CouldNotCreateCategoryException
    {
        if(categoryRequestDTO.getCategoryName() == null || categoryRequestDTO.getCategoryName().isEmpty())
        {
            throw new InvalidCategoryNameException("Cannot create category. The category name is empty or null.");
        }

        Category savedCategory = this.categoryService.createCategory(categoryRequestDTO.getCategoryName());
        if(savedCategory == null)
        {
            throw new CouldNotCreateCategoryException("Error creating category");
        }

        CategoryResponseDTO responseDTO = new CategoryResponseDTO();
        responseDTO.setCategoryName(savedCategory.getCategoryName());
        responseDTO.setCategoryCreated(true);

        return ResponseEntity.ok(responseDTO);


    }

}
