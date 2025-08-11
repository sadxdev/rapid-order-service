package com.bashverse.rapidorderservice.service;

import com.bashverse.rapidorderservice.entity.Order;
import com.bashverse.rapidorderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order existing = getOrderById(id);
        existing.setCustomerId(orderDetails.getCustomerId());
        existing.setProductId(orderDetails.getProductId());
        existing.setQuantity(orderDetails.getQuantity());
        existing.setPrice(orderDetails.getPrice());
        existing.setStatus(orderDetails.getStatus());
        return orderRepository.save(existing);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
