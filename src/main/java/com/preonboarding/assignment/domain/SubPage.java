package com.preonboarding.assignment.domain;

import java.util.List;
import lombok.Getter;

@Getter
public class SubPage {

    private final Long id;
    private final Long parentId;
    private final Long subId;

    public SubPage(Long id, Long parentId, Long subId) {
        validateParentId(parentId);
        validateSubId(subId);
        this.id = id;
        this.parentId = parentId;
        this.subId = subId;
    }

    private void validateParentId(Long parentId) {
        if (parentId == null) {
            throw new IllegalArgumentException("게시글 제목은 필수입니다.");
        }
    }

    private void validateSubId(Long subId) {
        if (subId == null) {
            throw new IllegalArgumentException("게시글 제목은 필수입니다.");
        }
    }
}
