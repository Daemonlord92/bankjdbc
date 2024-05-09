package org.blitmatthew.bankjdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class CleanupConfig {
    @Autowired
    protected DataSource dataSource;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event) {
        jdbcTemplate.execute("DROP TABLE IF EXISTS transaction");
        jdbcTemplate.execute("DROP TABLE IF EXISTS account");
        jdbcTemplate.execute("DROP TABLE IF EXISTS user_profile");
        jdbcTemplate.execute("DROP TABLE IF EXISTS user_credential");
    }
}
