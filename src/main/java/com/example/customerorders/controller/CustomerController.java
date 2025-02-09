package com.example.customerorders.controller;

import com.example.customerorders.model.Customer;
import com.example.customerorders.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();


        List<String> customerDetails = customers.stream()
                .map(customer -> "id: " + customer.getId() +
                        ", name: " + customer.getName() +
                        ", email: " + customer.getEmail() +
                        ", createdAt: " + customer.getCreatedAt())
                .collect(Collectors.toList());


        customerDetails.forEach(logger::info);

        return customers;
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Customer getCustomerById(@PathVariable UUID id) {
        Customer customer = customerService.getCustomerById(id);

        if (customer != null) {
            String customerDetail = "id: " + customer.getId() +
                    ", name: " + customer.getName() +
                    ", email: " + customer.getEmail() +
                    ", createdAt: " + customer.getCreatedAt();
            logger.info(customerDetail);
        }
        return customer;
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String createCustomer(@RequestBody Customer customer) {
        UUID randomId = UUID.randomUUID();

        customer.setId(randomId);

        try {
            customerService.createCustomer(customer);
            Customer createdCustomer = customerService.getCustomerById(customer.getId());
            String customerDetail = "id: " + createdCustomer.getId() +
                    ", name: " + createdCustomer.getName() +
                    ", email: " + createdCustomer.getEmail() +
                    ", createdAt: " + createdCustomer.getCreatedAt();
            logger.info(customerDetail);
            return "Customer created successfully!";
        } catch (IllegalArgumentException e) {
            logger.error("Failed to create customer: {}", e.getMessage());
            return "Failed to create customer: " + e.getMessage();
        }
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateCustomer(@PathVariable UUID id, @RequestBody Customer customer) {
        try {
            customerService.updateCustomer(id, customer);
            Customer updatedCustomer = customerService.getCustomerById(id);
            String customerDetail = "id: " + updatedCustomer.getId() +
                    ", name: " + updatedCustomer.getName() +
                    ", email: " + updatedCustomer.getEmail() +
                    ", createdAt: " + updatedCustomer.getCreatedAt();
            logger.info(customerDetail);

            return "Customer updated successfully!";
        } catch (IllegalArgumentException e) {
            logger.error("Failed to update customer: {}", e.getMessage());
            return "Failed to update customer: " + e.getMessage();
        }
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteCustomer(@PathVariable UUID id) {
        try {
            boolean deleted = customerService.deleteCustomer(id);
            if (deleted) {
                logger.info("id: {} deleted successfully.", id);
                return "Customer deleted successfully!";
            } else {
                logger.error("Customer with ID: {} not found.", id);
                return "Customer not found!";
            }
        } catch (IllegalArgumentException e) {
            logger.error("Failed to delete customer: {}", e.getMessage());
            return "Failed to delete customer: " + e.getMessage();
        }
    }
}
