package com.microservice.producerservie.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


public class PublishRequest implements Serializable {

    @Pattern(regexp = "^[a-zA-Z0-9]{1,10}", message = "Maximum length is 10")
    @NotBlank(message = "Customer Number is mandatory")
    private String customerNumber;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}

