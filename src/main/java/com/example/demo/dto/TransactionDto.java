package com.example.demo.dto;

import com.example.demo.entities.Transaction;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {

    private Long id;
    private LocalDateTime dateTransaction;
    private String prenomClient;
    private String nomClient;
    private String statutTransaction;

}
