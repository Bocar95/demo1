package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BagageDto;
import com.example.demo.service.interfaces.BagageInterface;

@RestController
@RequestMapping("/bagage")
public class BagageControlleur {

    private final BagageInterface bagageInterface;

    public BagageControlleur(BagageInterface bagageInterface) {
        this.bagageInterface = bagageInterface;
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
