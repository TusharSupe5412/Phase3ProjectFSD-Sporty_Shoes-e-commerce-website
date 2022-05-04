package com.sportyshoes.controllers;

import com.sportyshoes.dto.CategoryRequestDTO;
import com.sportyshoes.dto.ProductRequestDTO;
import com.sportyshoes.entities.Category;
import com.sportyshoes.entities.Product;
import com.sportyshoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> saveProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return new ResponseEntity<Product>(productService.saveProduct(productRequestDTO), HttpStatus.CREATED);
    }


    @GetMapping(value = "/product")
    public List<Product> getProduct() {

        return this.productService.getProduct();
    }

    @GetMapping(value = "/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductById(@PathVariable(name = "productId") int productId) {
        try {
            return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {

        return productService.updateProduct(product);
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> removeProductById(@PathVariable(name = "id") int id) {
        try {
            return new ResponseEntity<Product>(productService.removeProductById(id), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
