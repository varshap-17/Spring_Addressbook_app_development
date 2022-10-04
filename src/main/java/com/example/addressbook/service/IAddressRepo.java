package com.example.addressbook.service;

import com.example.addressbook.dto.AddressDto;
import com.example.addressbook.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IAddressRepo {
    public AddressBook PostData(AddressDto addressDto);
    public AddressBook UpdateById(Long id,AddressDto addressDto);
    public List<AddressBook> ListData();
    public Optional<AddressBook> findById(Long id);
    public AddressBook delete(Long id);
    public List<AddressBook> getFirstname(String firstname);
    public List<AddressBook> getDataByCity(String city);
}
