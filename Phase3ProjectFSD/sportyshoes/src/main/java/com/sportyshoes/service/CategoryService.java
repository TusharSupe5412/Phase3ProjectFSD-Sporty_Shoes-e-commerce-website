package com.sportyshoes.service;

import com.sportyshoes.dto.CategoryRequestDTO;
import com.sportyshoes.entities.Category;

import java.util.List;

public interface CategoryService {

    public Category saveCategory(CategoryRequestDTO categoryRequestDTO);

    public List<Category> GetCategory();

    public Category getCategoryById(int categoryId);

    public Category updateCategory(Category category);

    public Category removeCategoryById(int id);



}
