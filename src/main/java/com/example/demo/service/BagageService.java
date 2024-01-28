package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BagageDto;
import com.example.demo.service.interfaces.BagageInterface;

@Service
public class BagageService implements BagageInterface {

    @Override
    public List<BagageDto> getAllBagageDtos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBagageDtos'");
    }

    @Override
    public BagageDto getBagageDtoById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBagageDtoById'");
    }

    @Override
    public BagageDto addBagageDto(BagageDto bagageDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBagageDto'");
    }

    @Override
    public BagageDto updateBagageDto(BagageDto bagageDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBagageDto'");
    }
    
}
