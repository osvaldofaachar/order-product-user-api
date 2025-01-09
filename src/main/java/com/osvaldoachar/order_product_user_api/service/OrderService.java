package com.osvaldoachar.order_product_user_api.service;

import com.osvaldoachar.order_product_user_api.dto.OrderDto;
import com.osvaldoachar.order_product_user_api.entity.Order;
import com.osvaldoachar.order_product_user_api.entity.Product;
import com.osvaldoachar.order_product_user_api.entity.User;
import com.osvaldoachar.order_product_user_api.repository.OrderRepository;
import com.osvaldoachar.order_product_user_api.repository.ProductRepository;
import com.osvaldoachar.order_product_user_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> new OrderDto(order.getOrderId(), order.getOrderDate(), order.getUser().getUserId(),
                        order.getProducts().stream().map(Product::getProductId).toList()))
                .toList();
    }

    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return new OrderDto(order.getOrderId(), order.getOrderDate(), order.getUser().getUserId(),
                order.getProducts().stream().map(Product::getProductId).toList());
    }

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        User user = userRepository.findById(orderDto.user())
                .orElseThrow(() -> new RuntimeException("User not found"));
        order.setUser(user);
        List<Product> products = productRepository.findAllById(orderDto.productIds());
        order.setProducts(products);
        Order savedOrder = orderRepository.save(order);
        return new OrderDto(savedOrder.getOrderId(), savedOrder.getOrderDate(), savedOrder.getUser().getUserId(),
                savedOrder.getProducts().stream().map(Product::getProductId).toList());
    }

    public void deleteOrder(Long userId) {
        if (!orderRepository.existsById(userId)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(userId);
    }
}
