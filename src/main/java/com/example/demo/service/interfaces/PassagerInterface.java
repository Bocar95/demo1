package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.dto.PassagerDto;

public interface PassagerInterface {
        
    List<PassagerDto> getAllPassagerDto();

    PassagerDto getPassagerDtoById(Long id);

    PassagerDto addPassagerDto(PassagerDto passagerDto);

    PassagerDto updatePassagerDto(PassagerDto passagerDto);
    
}
