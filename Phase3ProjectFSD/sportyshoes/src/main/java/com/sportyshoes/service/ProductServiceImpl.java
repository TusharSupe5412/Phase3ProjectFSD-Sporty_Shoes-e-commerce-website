package com.sportyshoes.service;

import com.sportyshoes.dto.ProductRequestDTO;
import com.sportyshoes.entities.Product;
import com.sportyshoes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;


    @Override
    public Product saveProduct(ProductRequestDTO productRequestDTO) {
        return productRepository.save(DtoToEntityMapper(productRequestDTO));
    }

    @Override
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product removeProductById(int id) {
        Product p = productRepository.findById(id).get();
        productRepository.delete(p);

        return p;
    }


    public Product DtoToEntityMapper(ProductRequestDTO productRequestDTO){
        return Product.builder()
                .name(productRequestDTO.getName())
                .category(productRequestDTO.getCategory())
                .price(productRequestDTO.getPrice())
                .build();
//        Product product = new Product();
//        product.setName(productRequestDTO.getName());

    }
}
