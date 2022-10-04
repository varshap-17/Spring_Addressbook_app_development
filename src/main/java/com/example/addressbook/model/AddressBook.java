package com.example.addressbook.model;

import com.example.addressbook.dto.AddressDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class AddressBook {
    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String notes;
    private String mobileno;

    public AddressBook(){

    }
    public AddressBook(long id, AddressDto addressDto){
        super();
        this.id=id;
        this.firstname=addressDto.firstname;
        this.lastname=addressDto.lastname;
        this.address=addressDto.address;
        this.city=addressDto.city;
        this.state=addressDto.state;
        this.zipcode=addressDto.zipcode;
        this.notes=addressDto.notes;
        this.mobileno=addressDto.mobileno;
    }
    public AddressBook(AddressDto addressDto){
        this.firstname=addressDto.firstname;
        this.lastname=addressDto.lastname;
        this.address=addressDto.address;
        this.city=addressDto.city;
        this.state=addressDto.state;
        this.zipcode=addressDto.zipcode;
        this.notes=addressDto.notes;
        this.mobileno=addressDto.mobileno;
    }
}
