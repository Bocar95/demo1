package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PassagerDto;
import com.example.demo.service.interfaces.PassagerInterface;

@RestController
@RequestMapping("/passager")
public class PassagerControlleur {
    
    private final PassagerInterface passagerInterface;

    public PassagerControlleur(PassagerInterface passagerInterface) {
        this.passagerInterface = passagerInterface;
    }

    public List<PassagerDto> getAllPassagerDto() {
        return passagerInterface.getAllPassagerDto();
    }

    public PassagerDto getPassagerDtoById(Long id) {
        return passagerInterface.getPassagerDtoById(id);
    }

    public PassagerDto addPassagerDto(PassagerDto passagerDto) {
        return passagerInterface.addPassagerDto(passagerDto);
    }

    public PassagerDto updatePassagerDto(PassagerDto passagerDto) {
        return passagerInterface.updatePassagerDto(passagerDto);
    }

}
