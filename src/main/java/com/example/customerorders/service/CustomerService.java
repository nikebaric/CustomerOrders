package com.example.customerorders.service;

import com.example.customerorders.model.Customer;
import com.example.customerorders.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        logger.info("Getting all customers");
        return customerRepository.getAllCustomers();
    }

    public Customer getCustomerById(UUID id) {
        logger.info("Getting customer with ID: {}", id);
        Customer customer = customerRepository.getCustomerById(id);
        if (customer == null) {
            logger.warn("Customer with ID {} not found.", id);
            throw new IllegalArgumentException("Customer with ID " + id + " does not exist.");
        }
        return customer;
    }

    public void createCustomer(Customer customer) {
        validateCustomer(customer);

        logger.info("Creating customer with ID: {}", customer.getId());
        customerRepository.createCustomer(customer);
        logger.info("Customer with ID {} created successfully.", customer.getId());
    }

    public void updateCustomer(UUID id, Customer customer) {
        logger.info("Updating customer with ID: {}", id);


        validateCustomer(customer);


        Customer existingCustomer = customerRepository.getCustomerById(id);
        if (existingCustomer == null) {
            logger.warn("Customer with ID {} not found, cannot update.", id);
            throw new IllegalArgumentException("Customer with ID " + id + " does not exist.");
        }

        customerRepository.updateCustomer(id, customer);
        logger.info("Customer with ID {} updated successfully.", id);
    }

    public boolean deleteCustomer(UUID id) {
        logger.info("Deleting customer with ID: {}", id);

        Customer customer = customerRepository.getCustomerById(id);
        if (customer != null) {
            customerRepository.deleteCustomer(id);
            logger.info("Customer with ID {} deleted successfully.", id);
            return true;
        } else {
            logger.warn("Attempted to delete non-existing customer with ID: {}", id);
            return false;
        }
    }


    private void validateCustomer(Customer customer) {

        if (customer.getName() == null || customer.getName().length() < 3) {
            logger.error("Customer creation or update failed. Name must be at least 3 characters.");
            throw new IllegalArgumentException("Name must be at least 3 characters.");
        }


        if (customer.getEmail() == null || !isValidEmail(customer.getEmail())) {
            logger.error("Customer creation or update failed. Invalid email address.");
            throw new IllegalArgumentException("Invalid email address.");
        }
    }


    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
