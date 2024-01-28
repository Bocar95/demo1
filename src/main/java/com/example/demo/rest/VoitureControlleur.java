package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.VoitureDto;
import com.example.demo.service.interfaces.VoitureInterface;

@RestController
@RequestMapping("/voiture")
public class VoitureControlleur {
    
    private final VoitureInterface voitureInterface;

    public VoitureControlleur(VoitureInterface voitureInterface) {
        this.voitureInterface = voitureInterface;
    }

    public List<VoitureDto> getAllVoitureDto() {
        return voitureInterface.getAllVoitureDto();
    }

    public VoitureDto getVoitureDtoById(Long id) {
        return voitureInterface.getVoitureDtoById(id);
    }

    public VoitureDto addVoitureDto(VoitureDto voitureDto) {
        return voitureInterface.addVoitureDto(voitureDto);
    }

    public VoitureDto updateVoitureDto(VoitureDto voitureDto) {
        return voitureInterface.updateVoitureDto(voitureDto);
    }

}
