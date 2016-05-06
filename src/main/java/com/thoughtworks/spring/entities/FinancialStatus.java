package com.thoughtworks.spring.entities;

public enum FinancialStatus {
    GOOD_STANDING(1), DEBT(2), BANKRUPT(3);

    private int status;

    FinancialStatus(int status) {
        this.status = status;
    }
}
