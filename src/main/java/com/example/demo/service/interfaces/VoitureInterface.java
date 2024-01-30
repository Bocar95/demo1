package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.dto.VoitureDto;
import com.example.demo.dto.VoitureResumeDto;

public interface VoitureInterface {
            
    List<VoitureDto> getAllVoitureDto();

    List<VoitureResumeDto> getVoitureResumeDtos();

    VoitureDto getVoitureDtoById(Long id);

    VoitureDto addVoitureDto(VoitureDto voitureDto);

    VoitureDto updateVoitureDto(VoitureDto voitureDto);
    
}
