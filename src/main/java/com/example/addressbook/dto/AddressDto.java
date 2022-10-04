package com.example.addressbook.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AddressDto {
    @NotEmpty(message = "firstname should not be null")
    @Pattern(regexp = "^[A-Z]+[a-z]*$",message = "firstname is invalid")
    public String firstname;
    @NotBlank(message = "lastname should not be null")
    @Pattern(regexp = "^[A-Za-z]*$",message = "lastname should not be null")
    public String lastname;
    @NotEmpty(message = "address should not be null")
    public String address;
    @NotBlank(message = "city should not be null")
    public String city;
    @NotBlank(message = "state should not be null")
    public String state;
    @NotBlank(message = "zipcode should not be null")
    public String zipcode;
    @NotBlank(message = "notes should not be null")
    public String notes;
    @NotBlank(message = "mobile number should not be null")
    public String mobileno;

    public AddressDto(String firstname,String lastname,String address,String city,String state,String zipcode,String notes,String mobileno){
        this.firstname=firstname;
        this.lastname=lastname;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zipcode=zipcode;
        this.notes=notes;
        this.mobileno=mobileno;
    }
}
