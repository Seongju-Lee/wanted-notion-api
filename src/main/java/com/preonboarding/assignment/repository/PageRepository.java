package com.preonboarding.assignment.repository;

import com.preonboarding.assignment.domain.Page;
import java.util.Optional;

public interface PageRepository {

    Optional<Page> findById(Long pageId);
}
