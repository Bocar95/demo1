package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChauffeurDto;
import com.example.demo.service.interfaces.ChauffeurInterface;

@RestController
@RequestMapping("/chauffeur")
public class ChauffeurController {
    
    private final ChauffeurInterface chauffeurInterface;

    public ChauffeurController(ChauffeurInterface chauffeurInterface) {
        this.chauffeurInterface = chauffeurInterface;
    }

    public List<ChauffeurDto> getAllChauffeurDtos() {
        return chauffeurInterface.getAllChauffeurDtos();
    }

    public ChauffeurDto getChauffeurDtoById(Long id) {
        return chauffeurInterface.getChauffeurDtoById(id);
    }

    public ChauffeurDto addChauffeurDto(ChauffeurDto chauffeurDto) {
        return chauffeurInterface.addChauffeurDto(chauffeurDto);
    }

    public ChauffeurDto updateChauffeurDto(ChauffeurDto chauffeurDto) {
        return chauffeurInterface.updateChauffeurDto(chauffeurDto);
    }

}
