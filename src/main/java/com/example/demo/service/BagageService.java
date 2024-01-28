package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BagageDto;
import com.example.demo.entities.Bagage;
import com.example.demo.repositories.BagageRepository;
import com.example.demo.service.interfaces.BagageInterface;

@Service
public class BagageService implements BagageInterface {

    private final BagageRepository bagageRepository;

    public BagageService(BagageRepository bagageRepository) {
        this.bagageRepository = bagageRepository;
    }

    @Override
    public List<BagageDto> getAllBagageDtos() {
        List<BagageDto> bagageDtos = new ArrayList<>();
        List<Bagage> bagages = bagageRepository.findAll();
        if(bagages.size() > 0){
            bagageDtos = BagageDto.fromEntities(bagages);
        }
        return bagageDtos;
    }

    @Override
    public BagageDto getBagageDtoById(Long id) {
        BagageDto bagageDto = new BagageDto();
        Bagage bagage = bagageRepository.findById(id).orElse(null);
        if(bagage != null){
            bagageDto = BagageDto.fromEntity(bagage);
        }
        return bagageDto;
    }

    @Override
    public BagageDto addBagageDto(BagageDto bagageDto) {
        BagageDto bagageDtoSaved = new BagageDto();
        Bagage bagage = BagageDto.toEntity(bagageDto);
        bagage = bagageRepository.save(bagage);
        bagageDtoSaved = BagageDto.fromEntity(bagage);

        return bagageDtoSaved;
    }

    @Override
    public BagageDto updateBagageDto(BagageDto bagageDto) {
        Bagage newBagageData = new Bagage();
        BagageDto bagageUpdated = new BagageDto();
        Bagage bagageFromDB = bagageRepository.findById(bagageDto.getId()).orElse(null);
        if(bagageFromDB != null){
            newBagageData = BagageDto.toEntity(bagageDto);
            bagageFromDB = newBagageData;
            bagageFromDB = bagageRepository.save(bagageFromDB);
            bagageUpdated = BagageDto.fromEntity(bagageFromDB);
        }
        return bagageUpdated;
    }
    
}
