package com.osvaldoachar.order_product_user_api.dto;

import com.osvaldoachar.order_product_user_api.entity.Order;

import java.util.List;

public record ProductDto(
        Long productId,
        String name,
        Double price
) {
}
