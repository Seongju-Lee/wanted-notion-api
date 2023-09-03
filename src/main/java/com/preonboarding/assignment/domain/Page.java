package com.preonboarding.assignment.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Page {

    private final Long pageId;
    private final String title;
    private final String contents;
    private final String path;
    private List<Long> subpages = new ArrayList<>();

    public Page(Long pageId, String title, String contents, String path) {
        this.pageId = pageId;
        this.title = title;
        this.contents = contents;
        this.path = path;
    }
}
