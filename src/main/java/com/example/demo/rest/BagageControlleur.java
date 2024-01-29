package com.example.demo.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BagageDto;
import com.example.demo.service.interfaces.BagageInterface;

@Controller
@RequestMapping("/bagage")
public class BagageControlleur {

    private final BagageInterface bagageInterface;

    public BagageControlleur(BagageInterface bagageInterface) {
        this.bagageInterface = bagageInterface;
    }

    @GetMapping("liste")
    public String bagageIndex(Model model){
        List<BagageDto> bagageDtos = getAllBagageDtos();
        model.addAttribute("bagages", bagageDtos);
        return "bagage";
    }

    @GetMapping("{id}")
    public String bagageById(Model model, @PathVariable Long id){
        BagageDto bagageDto = getBagageDtoById(id);
        model.addAttribute("bagageDetail", bagageDto);
        return "bagage";
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
