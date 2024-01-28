package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Bagage;

public interface BagageRepository extends JpaRepository<Bagage, Long> {
    
}
