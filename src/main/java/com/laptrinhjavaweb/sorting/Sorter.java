package com.laptrinhjavaweb.sorting;

public class Sorter {
    private String sortExpression;
    private String sortDirection;

    public Sorter(String sortExpression, String sortDirection) {
        this.sortExpression = sortExpression;
        this.sortDirection = sortDirection;
    }

    public String getSortExpression() {
        return sortExpression;
    }

    public void setSortExpression(String sortExpression) {
        this.sortExpression = sortExpression;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }
}
