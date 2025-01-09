package com.osvaldoachar.order_product_user_api.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderDto(
        Long userId,
        LocalDateTime orderDate,
        UUID user,
        List<Long> productIds
) {
}
