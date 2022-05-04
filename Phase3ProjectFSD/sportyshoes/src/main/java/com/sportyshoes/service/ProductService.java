package com.sportyshoes.service;

import com.sportyshoes.dto.ProductRequestDTO;
import com.sportyshoes.entities.Category;
import com.sportyshoes.entities.Product;
import com.sportyshoes.repository.ProductRepository;

import java.util.List;

public interface ProductService {


    public Product saveProduct(ProductRequestDTO productRequestDTO);

    public List<Product> getProduct();

    public Product getProductById(int productId);

    public Product updateProduct(Product product);

    public Product removeProductById(int id);

}
