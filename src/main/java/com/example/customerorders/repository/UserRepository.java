package com.example.customerorders.repository;

import com.example.customerorders.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private final RowMapper<User> userRowMapper = new UserRowMapper();


    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.query(sql, userRowMapper, email).stream().findFirst();
    }


    public User save(User user) {

        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }

        String sql = "INSERT INTO users (id, email, password, role) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getId(), user.getEmail(), user.getPassword(), user.getRole().name());
        return user;
    }

    public class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(
                    UUID.fromString(rs.getString("id")),
                    rs.getString("email"),
                    rs.getString("password"),
                    User.Role.valueOf(rs.getString("role"))
            );
        }
    }
}

