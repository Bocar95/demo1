package com.example.demo.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ChauffeurDto;
import com.example.demo.dto.ChauffeurResumeDto;
import com.example.demo.dto.VoitureResumeDto;
import com.example.demo.service.interfaces.ChauffeurInterface;

@Controller
@RequestMapping("/chauffeur")
public class ChauffeurController {
    
    private final ChauffeurInterface chauffeurInterface;
    private final VoitureControlleur voitureControlleur;

    public ChauffeurController(ChauffeurInterface chauffeurInterface, VoitureControlleur voitureControlleur) {
        this.chauffeurInterface = chauffeurInterface;
        this.voitureControlleur = voitureControlleur;
    }

    @GetMapping("liste")
    public String chauffeurIndex(Model model){
        List<ChauffeurDto> chauffeurDtos = getAllChauffeurDtos();
        List<VoitureResumeDto> voitureResumeDtos = voitureControlleur.getVoitureResumeDtos();
        model.addAttribute("chauffeurs", chauffeurDtos);
        model.addAttribute("voitureResumeDtos", voitureResumeDtos);
        model.addAttribute("chauffeurDto", new ChauffeurDto());
        return "chauffeur";
    }

    @GetMapping("{id}")
    public String chauffeurById(Model model, @PathVariable Long id){
        ChauffeurDto chauffeurDto = getChauffeurDtoById(id);
        model.addAttribute("chauffeurDetail", chauffeurDto);
        return chauffeurIndex(model);
    }

    @PostMapping("/ajouter")
    public String ajouterBagage(@ModelAttribute("chauffeurDto") @Valid ChauffeurDto chauffeurDto, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/chauffeur/liste";
        }

        addChauffeurDto(chauffeurDto);
        return "redirect:/chauffeur/liste";
    }


    public List<ChauffeurDto> getAllChauffeurDtos() {
        return chauffeurInterface.getAllChauffeurDtos();
    }

    public List<ChauffeurResumeDto> getAllChauffeurResumeDtos() {
        return chauffeurInterface.getChauffeurResumeDtos();
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
