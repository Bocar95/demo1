package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.VoitureDto;
import com.example.demo.service.interfaces.VoitureInterface;

@Service
public class VoitureService implements VoitureInterface {

    @Override
    public List<VoitureDto> getAllVoitureDto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllVoitureDto'");
    }

    @Override
    public VoitureDto getVoitureDtoById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVoitureDtoById'");
    }

    @Override
    public VoitureDto addVoitureDto(VoitureDto voitureDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addVoitureDto'");
    }

    @Override
    public VoitureDto updateVoitureDto(VoitureDto voitureDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateVoitureDto'");
    }
    
}
