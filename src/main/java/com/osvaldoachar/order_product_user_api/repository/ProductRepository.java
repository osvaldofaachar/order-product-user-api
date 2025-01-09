package com.osvaldoachar.order_product_user_api.repository;

import com.osvaldoachar.order_product_user_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
