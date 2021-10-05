package com.microservice.producerservie.model;

public enum CustomerStatus {

    R("Restored"), S("Suspended"), O("Open"), C("Closed");

    private String statusString;

    private CustomerStatus(String statusString) {
        this.statusString = statusString;
    }
}
