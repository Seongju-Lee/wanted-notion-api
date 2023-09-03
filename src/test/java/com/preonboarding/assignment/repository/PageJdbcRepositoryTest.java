package com.preonboarding.assignment.repository;

import com.preonboarding.assignment.domain.Page;
import com.preonboarding.assignment.DatabaseInitializr;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PageJdbcRepositoryTest {

    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private DatabaseInitializr databaseInitializr;

    @BeforeEach
    void setUp() {
        databaseInitializr.initializeDatabase();
    }

    @Test
    public void testFindById() {
        // Arrange: 테스트 데이터베이스에 테스트용 데이터가 있어야 합니다.

        // Act
        Optional<Page> result = pageRepository.findById(1L);

        // Assert
        assertThat(result).isPresent();
        Page page = result.orElse(null);
        assertThat(page.getPageId()).isEqualTo(1L);
    }
}
