package com.example.repositories;

import com.example.model.Account;
import com.example.repositories.mappers.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        this.jdbcTemplate.update(sql, amount, id);
    }

    public Account findAccountById(long id) {
        String sql = "SELECT * FROM account WHERE id = ?";
        return this.jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }
}
