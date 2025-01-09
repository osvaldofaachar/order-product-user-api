package com.osvaldoachar.order_product_user_api.dto;


import java.util.UUID;

public record UserDto(
        UUID userId,
        String name,
        String email
) {
}
