package com.urise.webapp.model;

import java.io.Serializable;
import java.util.List;

public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Link homePage;

    private final List<PeriodOrganization> periodOrganizationList;

    public Organization(Link homePage, List<PeriodOrganization> periodOrganizationList) {
        this.homePage = homePage;
        this.periodOrganizationList = periodOrganizationList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (homePage != null ? !homePage.equals(that.homePage) : that.homePage != null) return false;
        return periodOrganizationList.equals(that.periodOrganizationList);
    }

    @Override
    public int hashCode() {
        int result = homePage != null ? homePage.hashCode() : 0;
        result = 31 * result + periodOrganizationList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", periodOrganizationList=" + periodOrganizationList +
                '}';
    }
}
