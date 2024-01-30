package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ChauffeurDto;
import com.example.demo.dto.ChauffeurResumeDto;
import com.example.demo.entities.Chauffeur;
import com.example.demo.repositories.ChauffeurRepository;
import com.example.demo.service.interfaces.ChauffeurInterface;

@Service
public class ChauffeurService implements ChauffeurInterface {

    private final ChauffeurRepository chauffeurRepository;

    public ChauffeurService(ChauffeurRepository chauffeurRepository) {
        this.chauffeurRepository = chauffeurRepository;
    }

    @Override
    public List<ChauffeurDto> getAllChauffeurDtos() {
        List<ChauffeurDto> chauffeurDtos = new ArrayList<>();
        List<Chauffeur> chauffeurs = chauffeurRepository.findAll();
        if(chauffeurs.size() > 0){
            chauffeurDtos = ChauffeurDto.fromEntities(chauffeurs);
        }
        return chauffeurDtos;
    }

    @Override
    public List<ChauffeurResumeDto> getChauffeurResumeDtos() {
        List<ChauffeurResumeDto> chauffeurResumeDtos = new ArrayList<>();
        List<Chauffeur> chauffeurs = chauffeurRepository.findAll();
        if(chauffeurs.size() > 0){
            chauffeurResumeDtos = ChauffeurResumeDto.fromEntities(chauffeurs);
        }
        return chauffeurResumeDtos;
    }

    @Override
    public ChauffeurDto getChauffeurDtoById(Long id) {
        ChauffeurDto chauffeurDto = new ChauffeurDto();
        Chauffeur chauffeur = chauffeurRepository.findById(id).orElse(null);
        if(chauffeur != null){
            chauffeurDto = ChauffeurDto.fromEntity(chauffeur);
        }
        return chauffeurDto;
    }

    @Override
    public ChauffeurDto addChauffeurDto(ChauffeurDto chauffeurDto) {
        ChauffeurDto chauffeurDtoSaved = new ChauffeurDto();
        Chauffeur chauffeur = ChauffeurDto.toEntity(chauffeurDto);
        chauffeur = chauffeurRepository.save(chauffeur);
        chauffeurDtoSaved = ChauffeurDto.fromEntity(chauffeur);

        return chauffeurDtoSaved;
    }

    @Override
    public ChauffeurDto updateChauffeurDto(ChauffeurDto chauffeurDto) {
        Chauffeur newChauffeurData = new Chauffeur();
        ChauffeurDto chauffeurUpdated = new ChauffeurDto();
        Chauffeur chauffeurFromDB = chauffeurRepository.findById(chauffeurDto.getId()).orElse(null);
        if(chauffeurFromDB != null){
            newChauffeurData = ChauffeurDto.toEntity(chauffeurDto);
            chauffeurFromDB = newChauffeurData;
            chauffeurFromDB = chauffeurRepository.save(chauffeurFromDB);
            chauffeurUpdated = ChauffeurDto.fromEntity(chauffeurFromDB);
        }
        return chauffeurUpdated;
    }
    
}
