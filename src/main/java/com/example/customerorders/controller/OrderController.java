package com.example.customerorders.controller;

import com.example.customerorders.model.Order;
import com.example.customerorders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    public List<Order> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();


        List<String> orderDetails = orders.stream()
                .map(order -> "id: " + order.getId() +
                        ", customerId: " + order.getCustomerId() +
                        ", orderDate: " + order.getOrderDate() +
                        ", totalAmount: " + order.getTotalAmount() +
                        ", status: " + order.getStatus() +
                        ", createdAt: " + order.getCreatedAt())
                .collect(Collectors.toList());

        orderDetails.forEach(logger::info);

        return orders;
    }


    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable UUID id) {
        Order order = orderService.getOrderById(id);

        if (order != null) {
            logger.info("id: {}, customerId: {}, orderDate: {}, totalAmount: {}, status: {}, createdAt: {}",
                    order.getId(), order.getCustomerId(), order.getOrderDate(), order.getTotalAmount(),



                    order.getStatus(), order.getCreatedAt());
        } else {
            logger.error("Order with ID: {} not found.", id);
        }

        return order;
    }


    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable UUID customerId) {
        List<Order> orders = orderService.getOrdersByCustomerId(customerId);


        List<String> orderDetails = orders.stream()
                .map(order -> "id: " + order.getId() +
                        ", customerId: " + order.getCustomerId() +
                        ", orderDate: " + order.getOrderDate() +
                        ", totalAmount: " + order.getTotalAmount() +
                        ", status: " + order.getStatus() +
                        ", createdAt: " + order.getCreatedAt())
                .collect(Collectors.toList());

        orderDetails.forEach(logger::info);

        return orders;
    }


    @PostMapping
    public String createOrder(@RequestBody Order order) {
        try {
            orderService.createOrder(order);
            Order createdOrder = orderService.getOrderById(order.getId());
            logger.info("Order created id: {}, customerId: {}, orderDate: {}, totalAmount: {}, status: {}, createdAt: {}",
                    createdOrder.getId(), createdOrder.getCustomerId(), createdOrder.getOrderDate(),



                    createdOrder.getTotalAmount(), createdOrder.getStatus(), createdOrder.getCreatedAt());
            return "Order created successfully.";
        } catch (IllegalArgumentException e) {
            logger.error("Failed to create order: {}", e.getMessage());
            return e.getMessage();
        }
    }


    @PutMapping("/{id}")
    public String updateOrder(@PathVariable UUID id, @RequestBody Order order) {
        try {
            orderService.updateOrder(id, order);
            Order updatedOrder = orderService.getOrderById(id);

            logger.info("Order updated id: {}, customerId: {}, orderDate: {}, totalAmount: {}, status: {}, createdAt: {}",
                    updatedOrder.getId(), updatedOrder.getCustomerId(), updatedOrder.getOrderDate(),



                    updatedOrder.getTotalAmount(), updatedOrder.getStatus(), updatedOrder.getCreatedAt());

            return "Order updated successfully.";
        } catch (IllegalArgumentException e) {
            logger.error("Failed to update order: {}", e.getMessage());
            return e.getMessage();
        }
    }


    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable UUID id) {
        boolean isDeleted = orderService.deleteOrder(id);
        if (isDeleted) {
            logger.info("Order deleted id: {} deleted successfully.", id);
            return "Order deleted successfully.";
        } else {
            logger.error("Order with ID: {} not found.", id);
            return "Order not found.";
        }
    }


    @GetMapping("/filter/orderDate")
    public List<Order> getOrdersByOrderDate(@RequestParam String orderDate) {
        List<Order> orders = orderService.getOrdersByOrderDate(orderDate);

        orders.forEach(order -> {
            logger.info("id: {}, customerId: {}, orderDate: {}, totalAmount: {}, status: {}, createdAt: {}",
                    order.getId(), order.getCustomerId(), order.getOrderDate(),
                    order.getTotalAmount(), order.getStatus(), order.getCreatedAt());
        });

        return orders;
    }


    @GetMapping("/filter/status")
    public List<Order> getOrdersByStatus(@RequestParam String status) {
        List<Order> orders = orderService.getOrdersByStatus(status);

        orders.forEach(order -> {
            logger.info("id: {}, customerId: {}, orderDate: {}, totalAmount: {}, status: {}, createdAt: {}",
                    order.getId(), order.getCustomerId(), order.getOrderDate(),
                    order.getTotalAmount(), order.getStatus(), order.getCreatedAt());
        });

        return orders;
    }


    @GetMapping("/page")
    public List<Order> getOrdersPage(@RequestParam int page, @RequestParam int size) {
        List<Order> orders = orderService.getOrdersPage(page, size);

        orders.forEach(order -> {
            logger.info("id: {}, customerId: {}, orderDate: {}, totalAmount: {}, status: {}, createdAt: {}",
                    order.getId(), order.getCustomerId(), order.getOrderDate(),
                    order.getTotalAmount(), order.getStatus(), order.getCreatedAt());
        });

        return orders;
    }
}
