package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Chauffeur;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
    
}
