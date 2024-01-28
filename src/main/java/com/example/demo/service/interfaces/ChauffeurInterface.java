package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.dto.ChauffeurDto;

public interface ChauffeurInterface {
    
    List<ChauffeurDto> getAllChauffeurDtos();

    ChauffeurDto getChauffeurDtoById(Long id);

    ChauffeurDto addChauffeurDto(ChauffeurDto chauffeurDto);

    ChauffeurDto updateChauffeurDto(ChauffeurDto chauffeurDto);
    
}
