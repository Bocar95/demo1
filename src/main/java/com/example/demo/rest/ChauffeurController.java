package com.example.demo.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ChauffeurDto;
import com.example.demo.service.interfaces.ChauffeurInterface;

@Controller
@RequestMapping("/chauffeur")
public class ChauffeurController {
    
    private final ChauffeurInterface chauffeurInterface;

    public ChauffeurController(ChauffeurInterface chauffeurInterface) {
        this.chauffeurInterface = chauffeurInterface;
    }

    @GetMapping("liste")
    public String bagageIndex(Model model){
        List<ChauffeurDto> chauffeurDtos = getAllChauffeurDtos();
        model.addAttribute("chauffeurs", chauffeurDtos);
        return "chauffeur";
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
