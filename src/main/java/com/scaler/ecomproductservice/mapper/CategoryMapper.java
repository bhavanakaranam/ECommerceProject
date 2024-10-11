package com.scaler.ecomproductservice.mapper;

import com.scaler.ecomproductservice.dto.CategoryListResponseDTO;
import com.scaler.ecomproductservice.dto.CategoryResponseDTO;
import com.scaler.ecomproductservice.models.Category;

import java.util.List;

public class CategoryMapper
{
    public static CategoryListResponseDTO convertCategoryListToCategoryListResponseDTO(List<Category> categoryList)
    {
        CategoryListResponseDTO categoryListResponseDTO = new CategoryListResponseDTO();
        for(Category category : categoryList)
        {
            CategoryResponseDTO responseDTO = new CategoryResponseDTO();
            responseDTO.setCategoryName(category.getCategoryName());
            categoryListResponseDTO.getCategoryResponseDTOList().add(responseDTO);
        }

        return categoryListResponseDTO;
    }

    public static CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category)
    {
        CategoryResponseDTO responseDTO = new CategoryResponseDTO();
        responseDTO.setCategoryName(category.getCategoryName());
        return responseDTO;
    }
}
