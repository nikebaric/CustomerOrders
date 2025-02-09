package com.example.customerorders.repository;

import com.example.customerorders.model.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }


    public Optional<Order> getOrderById(UUID id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new OrderRowMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    public List<Order> getOrdersByCustomerId(UUID customerId) {
        String sql = "SELECT * FROM orders WHERE \"customerId\" = ?";
        return jdbcTemplate.query(sql, new OrderRowMapper(), customerId);
    }


    @Transactional
    public boolean createOrder(Order order) {
        String sql = "INSERT INTO orders (id, \"customerId\", \"orderDate\", \"totalAmount\", status) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, order.getId(), order.getCustomerId(), order.getOrderDate(),
                order.getTotalAmount(), order.getStatus().toString()) > 0;
    }


    @Transactional
    public boolean updateOrder(UUID id, Order updatedOrder) {
        String sql = "UPDATE orders SET \"orderDate\" = ?, \"totalAmount\" = ?, status = ? WHERE id = ?";
        return jdbcTemplate.update(sql, updatedOrder.getOrderDate(), updatedOrder.getTotalAmount(),
                updatedOrder.getStatus().toString(), id) > 0;
    }


    @Transactional
    public boolean deleteOrder(UUID id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }


    public static class OrderRowMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Order(
                    UUID.fromString(rs.getString("id")),
                    UUID.fromString(rs.getString("customerId")),
                    rs.getDate("orderDate").toLocalDate(),
                    rs.getBigDecimal("totalAmount"),
                    Order.Status.valueOf(rs.getString("status")),
                    rs.getTimestamp("createdAt")
            );
        }
    }


    public List<Order> getOrdersByOrderDate(String orderDate) {
        String sql = "SELECT * FROM orders WHERE \"orderDate\" = CAST(? AS DATE)";
        return jdbcTemplate.query(sql, new OrderRowMapper(), orderDate);
    }


    public List<Order> getOrdersByStatus(String status) {
        String sql = "SELECT * FROM orders WHERE status = ?";
        return jdbcTemplate.query(sql, new OrderRowMapper(), status);
    }


    public List<Order> getOrdersPage(int page, int size) {
        String sql = "SELECT * FROM orders LIMIT ? OFFSET ?";
        int offset = page * size;
        return jdbcTemplate.query(sql, new OrderRowMapper(), size, offset);
    }
}
