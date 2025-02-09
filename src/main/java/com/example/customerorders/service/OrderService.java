package com.example.customerorders.service;

import com.example.customerorders.model.Order;
import com.example.customerorders.repository.CustomerRepository;
import com.example.customerorders.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public List<Order> getAllOrders() {
        logger.info("Getting all orders");
        List<Order> orders = orderRepository.getAllOrders();
        logger.debug("Retrieved {} orders", orders.size());
        return orders;
    }

    public Order getOrderById(UUID id) {
        logger.info("Getting order with ID: {}", id);
        Optional<Order> order = orderRepository.getOrderById(id);

        if (order.isPresent()) {
            logger.debug("Order details: {}", order.get());
            return order.get();
        } else {
            logger.warn("Order with ID {} not found.", id);
            return null;
        }
    }

    public List<Order> getOrdersByCustomerId(UUID customerId) {
        logger.info("Getting orders for customer with ID: {}", customerId);
        List<Order> orders = orderRepository.getOrdersByCustomerId(customerId);
        logger.debug("Customer {} has {} orders.", customerId, orders.size());
        return orders;
    }

    public void createOrder(Order order) {
        logger.info("Creating order for customer with ID: {}", order.getCustomerId());


        if (customerRepository.getCustomerById(order.getCustomerId()) == null) {
            logger.error("Customer with ID {} does not exist. Order creation failed.", order.getCustomerId());
            throw new IllegalArgumentException("Customer with ID " + order.getCustomerId() + " does not exist.");
        }


        if (order.getTotalAmount().doubleValue() <= 0) {
            logger.error("Order creation failed. Total amount must be greater than 0. Given: {}", order.getTotalAmount());
            throw new IllegalArgumentException("Total amount must be greater than 0.");
        }


        order.setId(UUID.randomUUID());

        orderRepository.createOrder(order);
        logger.info("Order successfully created with ID: {}", order.getId());
    }

    public void updateOrder(UUID id, Order order) {
        logger.info("Updating order with ID: {}", id);

        Optional<Order> existingOrderOpt = orderRepository.getOrderById(id);
        if (existingOrderOpt.isEmpty()) {
            logger.error("Order with ID {} not found.", id);
            throw new IllegalArgumentException("Order with ID " + id + " does not exist.");
        }

        Order existingOrder = existingOrderOpt.get();


        if (order.getTotalAmount().doubleValue() <= 0) {
            logger.error("Order update failed. Total amount must be greater than 0. Given: {}", order.getTotalAmount());
            throw new IllegalArgumentException("Total amount must be greater than 0.");
        }


        if (!isValidStatusTransition(existingOrder.getStatus(), order.getStatus())) {
            logger.error("Invalid status transition from {} to {} for order ID: {}", existingOrder.getStatus(), order.getStatus(), id);
            throw new IllegalArgumentException("Invalid status transition from " + existingOrder.getStatus() + " to " + order.getStatus());
        }

        orderRepository.updateOrder(id, order);
        logger.info("Order with ID {} updated successfully.", id);
    }

    public boolean deleteOrder(UUID id) {
        logger.info("Deleting order with ID: {}", id);

        Optional<Order> order = orderRepository.getOrderById(id);
        if (order.isPresent()) {
            orderRepository.deleteOrder(id);
            logger.info("Order with ID {} deleted successfully.", id);
            return true;
        } else {
            logger.warn("Attempted to delete non-existing order with ID: {}", id);
            return false;
        }
    }

    private boolean isValidStatusTransition(Order.Status oldStatus, Order.Status newStatus) {

        Map<Order.Status, Set<Order.Status>> validTransitions = new HashMap<>();
        validTransitions.put(Order.Status.NEW, Set.of(Order.Status.IN_PROGRESS, Order.Status.COMPLETED));
        validTransitions.put(Order.Status.IN_PROGRESS, Set.of(Order.Status.COMPLETED));

        return validTransitions.getOrDefault(oldStatus, Collections.emptySet()).contains(newStatus);
    }


    public List<Order> getOrdersByOrderDate(String orderDate) {
        logger.info("Getting orders by orderDate: {}", orderDate);
        return orderRepository.getOrdersByOrderDate(orderDate);
    }


    public List<Order> getOrdersByStatus(String status) {
        logger.info("Getting orders by status: {}", status);
        return orderRepository.getOrdersByStatus(status);
    }


    public List<Order> getOrdersPage(int page, int size) {
        logger.info("Getting orders with pagination - page: {}, size: {}", page, size);
        return orderRepository.getOrdersPage(page, size);
    }
}
