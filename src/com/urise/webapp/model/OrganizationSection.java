package com.urise.webapp.model;

import java.util.List;

public class OrganizationSection extends Section {
    private List<Organization> organizations;

    public OrganizationSection(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public void putContent(Object newContent) {
        organizations = (List<Organization>) newContent;
    }
}
