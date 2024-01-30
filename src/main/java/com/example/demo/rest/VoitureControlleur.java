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

import com.example.demo.dto.ChauffeurResumeDto;
import com.example.demo.dto.VoitureDto;
import com.example.demo.dto.VoitureResumeDto;
import com.example.demo.service.interfaces.ChauffeurInterface;
import com.example.demo.service.interfaces.VoitureInterface;

@Controller
@RequestMapping("/voiture")
public class VoitureControlleur {
    
    private final VoitureInterface voitureInterface;
    private final ChauffeurInterface chauffeurInterface;

    public VoitureControlleur(VoitureInterface voitureInterface,
            ChauffeurInterface chauffeurInterface) {
        this.voitureInterface = voitureInterface;
        this.chauffeurInterface = chauffeurInterface;
    }

    @GetMapping("liste")
    public String bagageIndex(Model model){
        List<VoitureDto> voitureDtos = getAllVoitureDto();
        List<ChauffeurResumeDto> chauffeurResumeDtos = chauffeurInterface.getChauffeurResumeDtos();
        model.addAttribute("voitures", voitureDtos);
        model.addAttribute("chauffeurResumeDtos", chauffeurResumeDtos);
        model.addAttribute("voitureDto", new VoitureDto());
        return "voiture";
    }

    @GetMapping("{id}")
    public String bagageById(Model model, @PathVariable Long id){
        VoitureDto voitureDto = getVoitureDtoById(id);
        model.addAttribute("voitureDetail", voitureDto);
        return bagageIndex(model);
    }

    @PostMapping("/ajouter")
    public String ajouterVoiture(@ModelAttribute("voitureDto") @Valid VoitureDto voitureDto, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/voiture/liste";
        }

        addVoitureDto(voitureDto);
        return "redirect:/voiture/liste";
    }

    public List<VoitureDto> getAllVoitureDto() {
        return voitureInterface.getAllVoitureDto();
    }

    public List<VoitureResumeDto> getVoitureResumeDtos() {
        return voitureInterface.getVoitureResumeDtos();
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
