/*
 * CustomerOrders API
 * API for managing customers and orders.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.Order;
import org.openapitools.client.model.OrderResponse;
import java.util.UUID;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for OrdersApi
 */
@Disabled
public class OrdersApiTest {

    private final OrdersApi api = new OrdersApi();

    /**
     * Create a new order
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createOrderTest() throws ApiException {
        Order order = null;
        Order response = api.createOrder(order);
        // TODO: test validations
    }

    /**
     * Delete an order by ID
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteOrderByIdTest() throws ApiException {
        UUID orderId = null;
        api.deleteOrderById(orderId);
        // TODO: test validations
    }

    /**
     * Get an order by ID
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getOrderByIdTest() throws ApiException {
        UUID orderId = null;
        OrderResponse response = api.getOrderById(orderId);
        // TODO: test validations
    }

    /**
     * Get all orders
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getOrdersTest() throws ApiException {
        List<Order> response = api.getOrders();
        // TODO: test validations
    }

    /**
     * Get all orders by customer ID
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getOrdersByCustomerIdTest() throws ApiException {
        UUID customerId = null;
        List<OrderResponse> response = api.getOrdersByCustomerId(customerId);
        // TODO: test validations
    }

    /**
     * Update an order by ID
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateOrderByIdTest() throws ApiException {
        UUID orderId = null;
        Order order = null;
        OrderResponse response = api.updateOrderById(orderId, order);
        // TODO: test validations
    }

}
