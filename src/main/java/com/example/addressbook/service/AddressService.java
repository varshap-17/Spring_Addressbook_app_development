package com.example.addressbook.service;

import com.example.addressbook.dto.AddressDto;
import com.example.addressbook.model.AddressBook;
import com.example.addressbook.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressRepo{
    @Autowired
    AddressRepository addressRepository;
    public AddressBook PostData(AddressDto addressDto){
        AddressBook addressBook=new AddressBook(addressDto);
        return addressRepository.save(addressBook);
    }
    public AddressBook UpdateById(Long id,AddressDto addressDto){
        AddressBook addressBook=new AddressBook(id,addressDto);
        addressRepository.save(addressBook);
        return addressBook;
    }
    public List<AddressBook> ListData(){
        return addressRepository.findAll();
    }
    public Optional<AddressBook> findById(Long id){
        return addressRepository.findById(id);
    }
    public AddressBook delete(Long id){
        addressRepository.deleteById(id);
        return null;
    }
    public List<AddressBook> getFirstname(String firstname){
        return addressRepository.findAddressBookByFirstname(firstname);
    }
    public List<AddressBook> getDataByCity(String city){
        return addressRepository.findAllByCity(city);
    }
}
