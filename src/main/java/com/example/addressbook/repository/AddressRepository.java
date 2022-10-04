package com.example.addressbook.repository;

import com.example.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressBook,Long> {
    @Query(value = "SELECT * from address_book where firstname=:firstname",nativeQuery = true)
    List<AddressBook> findAddressBookByFirstname(String firstname);
    @Query(value = "select * from address_book where city=:city",nativeQuery = true)
    List<AddressBook> findAllByCity(String city);
}
