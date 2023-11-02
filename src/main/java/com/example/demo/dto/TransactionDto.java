package com.example.demo.dto;

import com.example.demo.entities.Transaction;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public static TransactionDto fromEntity(Transaction transaction){
        if(transaction == null){
            return null;
        }
        return TransactionDto.builder()
            .id(transaction.getId())
            .dateTransaction(transaction.getDateTransaction())
            .prenomClient(transaction.getPrenomClient())
            .nomClient(transaction.getNomClient())
            .statutTransaction(transaction.getStatutTransaction()).build();
    }

    public static List<TransactionDto> fromEntities(List<Transaction> transactionList){
        if(transactionList.isEmpty() || transactionList == null){
            return Collections.emptyList();
        }
        return transactionList.stream().map(TransactionDto::fromEntity).collect(Collectors.toList());
    }

    public static Transaction toEntity(TransactionDto transactionDto){
        if(transactionDto == null){
            return null;
        }
        Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setDateTransaction(transactionDto.getDateTransaction());
        transaction.setPrenomClient(transactionDto.getPrenomClient());
        transaction.setNomClient(transactionDto.getNomClient());
        transaction.setStatutTransaction(transactionDto.getStatutTransaction());
        return transaction;
    }

    public static List<Transaction> toEntities(List<TransactionDto> transactionDtos){
        if(transactionDtos.isEmpty() || transactionDtos == null){
            return Collections.emptyList();
        }
        return transactionDtos.stream().map(TransactionDto::toEntity).collect(Collectors.toList());
    }

}
