package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.dto.ChauffeurDto;
import com.example.demo.dto.ChauffeurResumeDto;

public interface ChauffeurInterface {
    
    List<ChauffeurDto> getAllChauffeurDtos();

    List<ChauffeurResumeDto> getChauffeurResumeDtos();

    ChauffeurDto getChauffeurDtoById(Long id);

    ChauffeurDto addChauffeurDto(ChauffeurDto chauffeurDto);

    ChauffeurDto updateChauffeurDto(ChauffeurDto chauffeurDto);
    
}
