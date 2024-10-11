package com.scaler.ecomproductservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryListResponseDTO
{
    private List<CategoryResponseDTO> categoryResponseDTOList;

    public CategoryListResponseDTO(){
        this.categoryResponseDTOList = new ArrayList<>();
    }
}
