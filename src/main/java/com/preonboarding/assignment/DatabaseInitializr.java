package com.preonboarding.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatabaseInitializr {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseInitializr(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void initializeDatabase() {
        // 데이터베이스 테이블 생성
        jdbcTemplate.execute(
            "CREATE TABLE IF NOT EXISTS page (page_id INT AUTO_INCREMENT, title VARCHAR(255), contents TEXT, path TEXT, PRIMARY KEY (page_id))");

        // 데이터 삽입
        int johnDoe = jdbcTemplate.update(
            "INSERT INTO page (title, contents, path) VALUES (?, ?, ?)", "lee", "contents", "");
    }
}
