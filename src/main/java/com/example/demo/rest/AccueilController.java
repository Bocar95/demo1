package com.example.demo.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BagageDto;
import com.example.demo.dto.ChauffeurDto;
import com.example.demo.dto.PassagerDto;
import com.example.demo.dto.VoitureDto;

@Controller
@RequestMapping("/accueil")
public class AccueilController {
    
    private final VoitureControlleur voitureControlleur;
    private final ChauffeurController chauffeurController;
    private final PassagerControlleur passagerControlleur;
    private final BagageControlleur bagageControlleur;

    public AccueilController(VoitureControlleur voitureControlleur, ChauffeurController chauffeurController,
            PassagerControlleur passagerControlleur, BagageControlleur bagageControlleur) {
        this.voitureControlleur = voitureControlleur;
        this.chauffeurController = chauffeurController;
        this.passagerControlleur = passagerControlleur;
        this.bagageControlleur = bagageControlleur;
    }
    
    @GetMapping("index")
    public String index(Model model){
        List<BagageDto> bagageDtos = bagageControlleur.getAllBagageDtos();
        List<VoitureDto> voitureDtos = voitureControlleur.getAllVoitureDto();
        List<ChauffeurDto> chauffeurDtos = chauffeurController.getAllChauffeurDtos();
        List<PassagerDto> passagerDtos = passagerControlleur.getAllPassagerDto();
        
        model.addAttribute("bagages", bagageDtos);
        model.addAttribute("voitures", voitureDtos);
        model.addAttribute("chauffeurs", chauffeurDtos);
        model.addAttribute("passagers", passagerDtos);

        return "index";
    }

}
