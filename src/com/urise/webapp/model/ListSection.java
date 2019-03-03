package com.urise.webapp.model;

import java.util.List;

public class ListSection extends Section{
    private List<String> items;

    public ListSection(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public void putContent(Object newContent) {
        items = (List<String>) newContent;
    }
}
