package com.example.demo.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.PassagerDto;
import com.example.demo.dto.PassagerResumeDto;
import com.example.demo.service.interfaces.PassagerInterface;

@Controller
@RequestMapping("/passager")
public class PassagerControlleur {
    
    private final PassagerInterface passagerInterface;

    public PassagerControlleur(PassagerInterface passagerInterface) {
        this.passagerInterface = passagerInterface;
    }
    
    @GetMapping("liste")
    public String bagageIndex(Model model){
        List<PassagerDto> passagerDtos = getAllPassagerDto();
        model.addAttribute("passagers", passagerDtos);
        return "passager";
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
