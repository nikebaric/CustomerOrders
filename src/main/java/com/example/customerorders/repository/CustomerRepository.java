package com.example.customerorders.repository;

import com.example.customerorders.model.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM customers";
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }


    public Customer getCustomerById(UUID id) {
        String sql = "SELECT * FROM customers WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public boolean createCustomer(Customer customer) {
        String sql = "INSERT INTO customers (id, name, email) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, customer.getId(), customer.getName(), customer.getEmail()) > 0;
    }


    public boolean updateCustomer(UUID id, Customer customer) {
        String sql = "UPDATE customers SET name = ?, email = ? WHERE id = ?";
        return jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), id) > 0;
    }


    public boolean deleteCustomer(UUID id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }


    public class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Customer(
                    UUID.fromString(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getTimestamp("createdAt")
            );
        }
    }
}
