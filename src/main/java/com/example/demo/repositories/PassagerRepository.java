package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Long> {
    
}
