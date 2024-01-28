package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ChauffeurDto;
import com.example.demo.service.interfaces.ChauffeurInterface;

@Service
public class ChauffeurService implements ChauffeurInterface {

    @Override
    public List<ChauffeurDto> getAllChauffeurDtos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllChauffeurDtos'");
    }

    @Override
    public ChauffeurDto getChauffeurDtoById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getChauffeurDtoById'");
    }

    @Override
    public ChauffeurDto addChauffeurDto(ChauffeurDto chauffeurDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addChauffeurDto'");
    }

    @Override
    public ChauffeurDto updateChauffeurDto(ChauffeurDto chauffeurDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateChauffeurDto'");
    }
    
}
