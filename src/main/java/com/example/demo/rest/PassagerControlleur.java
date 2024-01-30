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

import com.example.demo.dto.PassagerDto;
import com.example.demo.dto.PassagerResumeDto;
import com.example.demo.dto.VoitureResumeDto;
import com.example.demo.service.interfaces.PassagerInterface;
import com.example.demo.service.interfaces.VoitureInterface;

@Controller
@RequestMapping("/passager")
public class PassagerControlleur {
    
    private final PassagerInterface passagerInterface;
    private final VoitureInterface voitureInterface;

    
    public PassagerControlleur(PassagerInterface passagerInterface, VoitureInterface voitureInterface) {
        this.passagerInterface = passagerInterface;
        this.voitureInterface = voitureInterface;
    }

    @GetMapping("liste")
    public String passagerIndex(Model model){
        List<PassagerDto> passagerDtos = getAllPassagerDto();
        List<VoitureResumeDto> voitureResumeDtos = voitureInterface.getVoitureResumeDtos();
        model.addAttribute("passagers", passagerDtos);
        model.addAttribute("voitureResumeDtos", voitureResumeDtos);
        model.addAttribute("passagerDto", new PassagerDto());
        return "passager";
    }
    
    @GetMapping("{id}")
    public String passagerById(Model model, @PathVariable Long id){
        PassagerDto passagerDto = getPassagerDtoById(id);
        model.addAttribute("passagerDetail", passagerDto);
        return passagerIndex(model);
    }

    
    @PostMapping("/ajouter")
    public String passagerBagage(@ModelAttribute("passagerDto") @Valid PassagerDto passagerDto, BindingResult result) {
        // if (result.hasErrors()) {
        //     return "redirect:/passager/liste";
        // }

        addPassagerDto(passagerDto);
        return "redirect:/passager/liste";
    }

    public List<PassagerDto> getAllPassagerDto() {
        return passagerInterface.getAllPassagerDto();
    }

    public List<PassagerResumeDto> getAllPassagerResumeDto() {
        return passagerInterface.getAllPassagerResumeDto();
    }

    public PassagerDto getPassagerDtoById(Long id) {
        return passagerInterface.getPassagerDtoById(id);
    }

    public PassagerDto addPassagerDto(PassagerDto passagerDto) {
        return passagerInterface.addPassagerDto(passagerDto);
    }

    public PassagerDto updatePassagerDto(PassagerDto passagerDto) {
        return passagerInterface.updatePassagerDto(passagerDto);
    }

}
