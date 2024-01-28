package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PassagerDto;
import com.example.demo.service.interfaces.PassagerInterface;

@Service
public class PassagerService implements PassagerInterface {

    @Override
    public List<PassagerDto> getAllPassagerDto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPassagerDto'");
    }

    @Override
    public PassagerDto getPassagerDtoById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassagerDtoById'");
    }

    @Override
    public PassagerDto addPassagerDto(PassagerDto passagerDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPassagerDto'");
    }

    @Override
    public PassagerDto updatePassagerDto(PassagerDto passagerDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePassagerDto'");
    }
    
}
