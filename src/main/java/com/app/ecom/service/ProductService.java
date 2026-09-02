package com.app.ecom.service;
import org.springframework.stereotype.Service;
import com.app.ecom.dto.ProductRequest;
import com.app.ecom.dto.ProductResponse;
import com.app.ecom.model.Product;
import com.app.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService{


    private final ProductRepository productRepository;
    public ProductResponse createProduct(ProductRequest productRequest) {
        // Logic to create a new product
        Product product = new Product();
        updateProductFromRequest(productRequest, product);
        Product savedProduct = productRepository.save(product);
        return mapToProductResponse(savedProduct);
    }
    private void updateProductFromRequest(ProductRequest productRequest, Product product) {
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setCategory(productRequest.getCategory());
        product.setImageUrl(productRequest.getImageUrl());
    }
public ProductResponse mapToProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setStockQuantity(product.getStockQuantity());
        productResponse.setCategory(product.getCategory());
        productResponse.setImageUrl(product.getImageUrl());
        return productResponse;
    }
}