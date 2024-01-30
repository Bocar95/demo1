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

import com.example.demo.dto.BagageDto;
import com.example.demo.dto.PassagerResumeDto;
import com.example.demo.service.interfaces.BagageInterface;

@Controller
@RequestMapping("/bagage")
public class BagageControlleur {

    private final BagageInterface bagageInterface;
    private final PassagerControlleur passagerControlleur;

    public BagageControlleur(BagageInterface bagageInterface, PassagerControlleur passagerControlleur) {
        this.bagageInterface = bagageInterface;
        this.passagerControlleur = passagerControlleur;
    }

    @GetMapping("liste")
    public String bagageIndex(Model model){
        List<BagageDto> bagageDtos = getAllBagageDtos();
        List<PassagerResumeDto> passagerResumeDtos = passagerControlleur.getAllPassagerResumeDto();
        model.addAttribute("bagages", bagageDtos);
        model.addAttribute("passagerResumeDtos", passagerResumeDtos);
        model.addAttribute("bagageDto", new BagageDto());
        return "bagage";
    }

    @GetMapping("{id}")
    public String bagageById(Model model, @PathVariable Long id){
        BagageDto bagageDto = getBagageDtoById(id);
        model.addAttribute("bagageDetail", bagageDto);
        return bagageIndex(model);
    }

    @PostMapping("/ajouter")
    public String ajouterBagage(@ModelAttribute("bagageDto") @Valid BagageDto bagageDto, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/bagage/liste";
        }

        addBagageDto(bagageDto);
        return "redirect:/bagage/liste";
    }

    public List<BagageDto> getAllBagageDtos() {
        return bagageInterface.getAllBagageDtos();
    }

    public BagageDto getBagageDtoById(Long id) {
        return bagageInterface.getBagageDtoById(id);
    }

    public BagageDto addBagageDto(BagageDto bagageDto) {
        return bagageInterface.addBagageDto(bagageDto);
    }

    public BagageDto updateBagageDto(BagageDto bagageDto) {
        return bagageInterface.updateBagageDto(bagageDto);
    }
    
}
