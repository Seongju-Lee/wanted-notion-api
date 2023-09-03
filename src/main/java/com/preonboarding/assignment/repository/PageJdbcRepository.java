package com.preonboarding.assignment.repository;

import com.preonboarding.assignment.domain.Page;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PageJdbcRepository implements PageRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Optional<Page> findById(Long pageId) {
        MapSqlParameterSource paramMap = new MapSqlParameterSource()
            .addValue("pageId", pageId);
        return Optional.ofNullable(
            jdbcTemplate.queryForObject("select * from page where page_id = :pageId", paramMap,
                productRowMapper)
        );
    }


    private final static RowMapper<Page> productRowMapper = (resultSet, i) -> {
        Long pageId = resultSet.getLong("page_id");
        String title = resultSet.getString("title");
        String contents = resultSet.getString("contents");
        String path = resultSet.getString("path");

        return new Page(pageId, title, contents, path);
    };
}
