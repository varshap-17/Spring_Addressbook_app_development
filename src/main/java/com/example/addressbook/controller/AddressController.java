package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressDto;
import com.example.addressbook.dto.ResponseDto;
import com.example.addressbook.model.AddressBook;
import com.example.addressbook.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;
    @GetMapping("/example")
    public String example(@RequestParam String name) {
        return "Hai "+name;
    }
    @PostMapping("/post")
    public ResponseEntity<ResponseDto> postData(@Valid @RequestBody AddressDto addressDto){
        AddressBook addressBook=null;
        addressBook=addressService.PostData(addressDto);
        ResponseDto responseDto=new ResponseDto("saved data successfully",addressBook);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateData(@Valid @PathVariable Long id, @RequestBody AddressDto addressDto){
        AddressBook addressBook=addressService.UpdateById(id,addressDto);
        ResponseDto responseDto=new ResponseDto("updated data successfully",addressBook);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public List<AddressBook> listAll(){
        return addressService.ListData();
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDto> listById(@PathVariable Long id){
        Optional<AddressBook> addressBook=null;
        addressBook=addressService.findById(id);
        ResponseDto responseDto=new ResponseDto("get call for id successful",addressBook);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable Long id){
        addressService.delete(id);
        ResponseDto responseDto=new ResponseDto("deleted id:"+id+" successfully",id);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }

    @GetMapping("/getName/{firstname}")
    public ResponseEntity<ResponseDto> getByName(@PathVariable String firstname){
        List<AddressBook> addressBooks=addressService.getFirstname(firstname);
        ResponseDto responseDto=new ResponseDto("get address details by name ",addressBooks);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @GetMapping("/getDetails/{city}")
    public ResponseEntity<ResponseDto> getByCity(@PathVariable String city){
        List<AddressBook> addressBooks=addressService.getDataByCity(city);
        ResponseDto responseDto=new ResponseDto("get other details",addressBooks);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
}
