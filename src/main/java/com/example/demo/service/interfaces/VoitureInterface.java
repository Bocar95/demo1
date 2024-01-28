package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.dto.VoitureDto;

public interface VoitureInterface {
            
    List<VoitureDto> getAllVoitureDto();

    VoitureDto getVoitureDtoById(Long id);

    VoitureDto addVoitureDto(VoitureDto voitureDto);

    VoitureDto updateVoitureDto(VoitureDto voitureDto);
    
}
