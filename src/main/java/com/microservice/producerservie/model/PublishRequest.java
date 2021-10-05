package com.microservice.producerservie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


public class PublishRequest implements Serializable {

    @Pattern(regexp = "^[a-zA-Z0-9]{1,10}", message = "Maximum length is 10")
    @NotEmpty(message = "Customer Number is mandatory")
    private String customerNumber;

    //    @Min(value = 10, message = "length should be atleast 10")
//    @Max(value = 50, message = "length should be at most 50")
    @Size(min = 10, max = 50, message = "First Name size should be within 10 to 50 range")
    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    //    @Min(value = 10, message = "length should be atleast than 10")
//    @Max(value = 50, message = "length should be at most 50")
    @NotBlank(message = "Last Name is mandatory")
    @Size(min = 10, max = 50, message = "First Name size should be within 10 to 50 range")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotNull
    private Date birthDate;

    @NotBlank(message = "Country Name is mandatory")
    private String country;

    @Size(min = 2, message = "First Name size should be within 10 to 50 range")
    @NotBlank(message = "Country Code is mandatory")
    private String countryCode;

    @Pattern(regexp = "^[a-zA-Z0-9]{10}", message = "Maximum length is 10")
    @NotBlank(message = "Mobile Number is mandatory")
    private String mobileNumber;

    @Size(max = 50, message = "First Name size should be greater than or equal to 50")

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotNull
    private CustomerStatus customerStatus;

    private Address address;


    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

