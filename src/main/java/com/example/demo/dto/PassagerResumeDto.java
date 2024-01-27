package com.example.demo.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entities.Passager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassagerResumeDto {

    private Long id;
    private String prenomPassager;
    private String nomPassager;
    private String adressePassager;
    private Integer telephonePassager;
    private Integer cniPassager;

    public static PassagerResumeDto fromEntity(Passager passager){
        if(passager == null){
            return null;
        }
        return PassagerResumeDto.builder()
            .id(passager.getId())
            .prenomPassager(passager.getPrenomPassager())
            .nomPassager(passager.getNomPassager())
            .adressePassager(passager.getAdressePassager())
            .telephonePassager(passager.getTelephonePassager())
            .cniPassager(passager.getCniPassager())
            .build();
    }

    public static List<PassagerResumeDto> fromEntities(List<Passager> passagers){
        if(passagers.isEmpty() || passagers == null){
            return Collections.emptyList();
        }
        return passagers.stream().map(PassagerResumeDto::fromEntity).collect(Collectors.toList());
    }

    public static Passager toEntity(PassagerResumeDto passagerResumeDto){
        if(passagerResumeDto == null){
            return null;
        }
        Passager passager = new Passager();
        passager.setId(passagerResumeDto.getId());
        passager.setPrenomPassager(passagerResumeDto.getPrenomPassager());
        passager.setNomPassager(passagerResumeDto.getNomPassager());
        passager.setAdressePassager(passagerResumeDto.getAdressePassager());
        passager.setTelephonePassager(passagerResumeDto.getTelephonePassager());
        passager.setCniPassager(passagerResumeDto.getCniPassager());

        return passager;
    }

    public static List<Passager> toEntities(List<PassagerResumeDto> passagerResumeDtos){
        if(passagerResumeDtos.isEmpty() || passagerResumeDtos == null){
            return Collections.emptyList();
        }
        return passagerResumeDtos.stream().map(PassagerResumeDto::toEntity).collect(Collectors.toList());
    }
       
}
