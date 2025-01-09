package com.osvaldoachar.order_product_user_api.repository;

import com.osvaldoachar.order_product_user_api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
