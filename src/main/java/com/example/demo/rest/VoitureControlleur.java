package com.example.demo.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.VoitureDto;
import com.example.demo.service.interfaces.VoitureInterface;

@Controller
@RequestMapping("/voiture")
public class VoitureControlleur {
    
    private final VoitureInterface voitureInterface;

    public VoitureControlleur(VoitureInterface voitureInterface) {
        this.voitureInterface = voitureInterface;
    }
        
    @GetMapping("liste")
    public String bagageIndex(Model model){
        List<VoitureDto> voitureDtos = getAllVoitureDto();
        model.addAttribute("voitures", voitureDtos);
        return "voiture";
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
