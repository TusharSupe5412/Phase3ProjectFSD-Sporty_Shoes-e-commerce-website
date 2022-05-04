package com.sportyshoes.service;

import com.sportyshoes.dto.CategoryRequestDTO;
import com.sportyshoes.entities.Category;
import com.sportyshoes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(CategoryRequestDTO categoryRequestDTO) {

        return categoryRepository.save(DtoToEntityMapper(categoryRequestDTO));
    }

    @Override
    public List<Category> GetCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category removeCategoryById(int id) {

        Category c = categoryRepository.findById(id).get();
        categoryRepository.delete(c);
        return c;
    }


    public Category DtoToEntityMapper(CategoryRequestDTO categoryRequestDTO){
        return Category.builder()
                .name(categoryRequestDTO.getName())
                .build();
    }
}
