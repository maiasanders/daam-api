package com.daam.model;

public enum OrderStatus {
    COMPLETED("completed"),
    PROBLEM("problem"),
    READY_FOR_GUEST("readyForGuest"),
    NEW("new");

    public final String label;
    private OrderStatus(String label) {
        this.label = label;
    }
}
