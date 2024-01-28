package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.dto.BagageDto;

public interface BagageInterface {

    List<BagageDto> getAllBagageDtos();

    BagageDto getBagageDtoById(Long id);

    BagageDto addBagageDto(BagageDto bagageDto);

    BagageDto updateBagageDto(BagageDto bagageDto);
    
}
