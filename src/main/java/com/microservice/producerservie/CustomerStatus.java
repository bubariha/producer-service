package com.microservice.producerservie;

public enum CustomerStatus {

    R("CustomerStatus"), S("CustomerStatus"), O("CustomerStatus"), C("Closed");

    private String statusString;
    private CustomerStatus(String statusString){
        this.statusString = statusString;
    }
}
