package com.microservice.producerservie.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class Address implements Serializable {

    @Max(value = 50, message = "Address line1 should be at most 50")
    @NotBlank(message = "Address Line1 is mandatory")
    private String addressLine1;

    private String addressLine2;

    private String street;

    @Max(value = 50, message = "Postal code should be at most 50")
    @NotBlank(message = "Postal code is mandatory")
    private String postalCode;


    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
