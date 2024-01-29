package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PassagerDto;
import com.example.demo.dto.PassagerResumeDto;
import com.example.demo.entities.Passager;
import com.example.demo.repositories.PassagerRepository;
import com.example.demo.service.interfaces.PassagerInterface;

@Service
public class PassagerService implements PassagerInterface {

    private final PassagerRepository passagerRepository;

    public PassagerService(PassagerRepository passagerRepository) {
        this.passagerRepository = passagerRepository;
    }

    @Override
    public List<PassagerDto> getAllPassagerDto() {
        List<PassagerDto> passagerDtos = new ArrayList<>();
        List<Passager> passagers = passagerRepository.findAll();
        if(passagers.size() > 0){
            passagerDtos = PassagerDto.fromEntities(passagers);
        }
        return passagerDtos;
    }

    @Override
    public List<PassagerResumeDto> getAllPassagerResumeDto() {
        List<PassagerResumeDto> passagerResumeDtos = new ArrayList<>();
        List<Passager> passagers = passagerRepository.findAll();
        if(passagers.size() > 0){
            passagerResumeDtos = PassagerResumeDto.fromEntities(passagers);
        }
        return passagerResumeDtos;
    }

    @Override
    public PassagerDto getPassagerDtoById(Long id) {
        PassagerDto passagerDto = new PassagerDto();
        Passager passager = passagerRepository.findById(id).orElse(null);
        if(passager != null){
            passagerDto = PassagerDto.fromEntity(passager);
        }
        return passagerDto;
    }

    @Override
    public PassagerDto addPassagerDto(PassagerDto passagerDto) {
        PassagerDto passagerDtoSaved = new PassagerDto();
        Passager passager = PassagerDto.toEntity(passagerDto);
        passager = passagerRepository.save(passager);
        passagerDtoSaved = PassagerDto.fromEntity(passager);

        return passagerDtoSaved;
    }

    @Override
    public PassagerDto updatePassagerDto(PassagerDto passagerDto) {
        Passager newPassagerData = new Passager();
        PassagerDto passagerUpdated = new PassagerDto();
        Passager passagerFromDB = passagerRepository.findById(passagerDto.getId()).orElse(null);
        if(passagerFromDB != null){
            newPassagerData = PassagerDto.toEntity(passagerDto);
            passagerFromDB = newPassagerData;
            passagerFromDB = passagerRepository.save(passagerFromDB);
            passagerUpdated = PassagerDto.fromEntity(passagerFromDB);
        }
        return passagerUpdated;
    }
    
}
