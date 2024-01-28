package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.VoitureDto;
import com.example.demo.entities.Voiture;
import com.example.demo.repositories.VoitureRepository;
import com.example.demo.service.interfaces.VoitureInterface;

@Service
public class VoitureService implements VoitureInterface {

    private final VoitureRepository voitureRepository;

    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    @Override
    public List<VoitureDto> getAllVoitureDto() {
        List<VoitureDto> voitureDtos = new ArrayList<>();
        List<Voiture> voitures = voitureRepository.findAll();
        if(voitures.size() > 0){
            voitureDtos = VoitureDto.fromEntities(voitures);
        }
        return voitureDtos;
    }

    @Override
    public VoitureDto getVoitureDtoById(Long id) {
        VoitureDto voitureDto = new VoitureDto();
        Voiture voiture = voitureRepository.findById(id).orElse(null);
        if(voiture != null){
            voitureDto = VoitureDto.fromEntity(voiture);
        }
        return voitureDto;
    }

    @Override
    public VoitureDto addVoitureDto(VoitureDto voitureDto) {
        VoitureDto voitureDtoSaved = new VoitureDto();
        Voiture voiture = VoitureDto.toEntity(voitureDto);
        voiture = voitureRepository.save(voiture);
        voitureDtoSaved = VoitureDto.fromEntity(voiture);

        return voitureDtoSaved;
    }

    @Override
    public VoitureDto updateVoitureDto(VoitureDto voitureDto) {
        Voiture newVoitureData = new Voiture();
        VoitureDto voitureUpdated = new VoitureDto();
        Voiture voitureFromDB = voitureRepository.findById(voitureDto.getId()).orElse(null);
        if(voitureFromDB != null){
            newVoitureData = VoitureDto.toEntity(voitureDto);
            voitureFromDB = newVoitureData;
            voitureFromDB = voitureRepository.save(voitureFromDB);
            voitureUpdated = VoitureDto.fromEntity(voitureFromDB);
        }
        return voitureUpdated;
    }
    
}
