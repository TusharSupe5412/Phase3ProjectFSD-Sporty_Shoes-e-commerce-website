package com.sportyshoes.controllers;

import com.sportyshoes.dto.CategoryRequestDTO;
import com.sportyshoes.entities.Category;
import com.sportyshoes.repository.CategoryRepository;
import com.sportyshoes.service.CategoryService;
import com.sportyshoes.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping(value = "/category", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> saveCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        return new ResponseEntity<Category>(categoryService.saveCategory(categoryRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/category")
    public List<Category> getCategory() {
        return this.categoryService.GetCategory();
    }

    @GetMapping(value = "/category/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategoryById(@PathVariable(name = "categoryId") int categoryId) {
        try {
            return new ResponseEntity<Category>(categoryService.getCategoryById(categoryId), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/category")
    public Category updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }


    @DeleteMapping("/category/{id}")
    public ResponseEntity<Category> removeCategoryById(@PathVariable(name = "id") int id) {
        try {
            return new ResponseEntity<Category>(categoryService.removeCategoryById(id), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
