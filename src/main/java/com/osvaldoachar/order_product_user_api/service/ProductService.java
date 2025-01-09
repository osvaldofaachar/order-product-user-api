package com.osvaldoachar.order_product_user_api.service;

import com.osvaldoachar.order_product_user_api.dto.ProductDto;
import com.osvaldoachar.order_product_user_api.entity.Product;
import com.osvaldoachar.order_product_user_api.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductDto(product.getProductId(), product.getName(), product.getPrice()))
                .toList();
    }

    public ProductDto getProductById(Long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("Product Not Found"));
        return new ProductDto(product.getProductId(), product.getName(), product.getPrice());
    }

    public ProductDto createProduct(ProductDto productDto){
        Product product = new Product();

        product.setName(productDto.name());
        product.setPrice(productDto.price());

        Product savedProduct = productRepository.save(product);
        return new ProductDto(savedProduct.getProductId(), savedProduct.getName(), savedProduct.getPrice());
    }

    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDto.name());
        product.setPrice(productDto.price());
        Product updatedProduct = productRepository.save(product);
        return new ProductDto(updatedProduct.getProductId(), updatedProduct.getName(), updatedProduct.getPrice());
    }

    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(productId);
    }
}
