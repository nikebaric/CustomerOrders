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
import org.openapitools.client.model.Customer;
import java.util.UUID;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CustomersApi
 */
@Disabled
public class CustomersApiTest {

    private final CustomersApi api = new CustomersApi();

    /**
     * Create a new customer
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createCustomerTest() throws ApiException {
        Customer customer = null;
        Customer response = api.createCustomer(customer);
        // TODO: test validations
    }

    /**
     * Delete a customer by ID
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteCustomerByIdTest() throws ApiException {
        UUID customerId = null;
        api.deleteCustomerById(customerId);
        // TODO: test validations
    }

    /**
     * Get a customer by ID
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getCustomerByIdTest() throws ApiException {
        UUID customerId = null;
        Customer response = api.getCustomerById(customerId);
        // TODO: test validations
    }

    /**
     * Get all customers
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getCustomersTest() throws ApiException {
        List<Customer> response = api.getCustomers();
        // TODO: test validations
    }

    /**
     * Update a customer by ID
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateCustomerByIdTest() throws ApiException {
        UUID customerId = null;
        Customer customer = null;
        Customer response = api.updateCustomerById(customerId, customer);
        // TODO: test validations
    }

}
