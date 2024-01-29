package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.dto.PassagerDto;
import com.example.demo.dto.PassagerResumeDto;

public interface PassagerInterface {
        
    List<PassagerDto> getAllPassagerDto();

    List<PassagerResumeDto> getAllPassagerResumeDto();

    PassagerDto getPassagerDtoById(Long id);

    PassagerDto addPassagerDto(PassagerDto passagerDto);

    PassagerDto updatePassagerDto(PassagerDto passagerDto);
    
}
