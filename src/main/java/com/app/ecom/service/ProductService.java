package com.app.ecom.service;

import com.app.ecom.dto.ProductRequest;
import com.app.ecom.dto.ProductResponse;
import com.app.ecom.model.Product;
import com.app.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> getAllProducts() {
        return productRepository.findByActiveTrue().stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }

    public Optional<ProductResponse> getProduct(Long id) {
        return productRepository.findById(id)
                .map(this::mapToProductResponse);
    }

    public boolean updateProduct(ProductRequest productRequest, Long id) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    updateProductFromRequest(productRequest, existingProduct);
                    productRepository.save(existingProduct);
                    return true;
                })
                .orElse(false);
    }

    public boolean deleteProduct(Long id) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setActive(false);
                    productRepository.save(existingProduct);
                    return true;
                })
                .orElse(false);
    }

    public ProductResponse createProduct(ProductRequest productRequest) {
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
        if (product.getActive() == null) {
            product.setActive(true);
        }
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
        productResponse.setActive(product.getActive());
        return productResponse;
    }
}