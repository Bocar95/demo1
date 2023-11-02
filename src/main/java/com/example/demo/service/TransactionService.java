package com.example.demo.service;

import com.example.demo.dto.TransactionDto;
import com.example.demo.entities.Transaction;
import com.example.demo.repositories.TransactionRepository;
import com.example.demo.service.interfaces.TransactionInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements TransactionInterface {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionDto> getAllTransaction() {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        List<Transaction> transactionList = transactionRepository.findAll();
        if(transactionList.size() > 0){
            transactionDtoList = TransactionDto.fromEntities(transactionList);
        }
        return transactionDtoList;
    }

    @Override
    public TransactionDto getTransactionById(Long id) {
        TransactionDto transactionDto = new TransactionDto();
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if(transaction != null){
            transactionDto = TransactionDto.fromEntity(transaction);
        }
        return transactionDto;
    }

    @Override
    public TransactionDto addTransaction(TransactionDto transactionDto) {
        LocalDateTime now = LocalDateTime.now();
        TransactionDto transactionDtoSaved = new TransactionDto();
        transactionDto.setDateTransaction(now);
        Transaction transaction = TransactionDto.toEntity(transactionDto);
        transaction = transactionRepository.save(transaction);
        transactionDtoSaved = TransactionDto.fromEntity(transaction);

        return transactionDtoSaved;
    }

    @Override
    public TransactionDto updateTransaction(TransactionDto transactionDto) {
        Transaction newTransactionData = new Transaction();
        TransactionDto transactionUpdated = new TransactionDto();
        Transaction transactionFromDb = transactionRepository.findById(transactionDto.getId()).orElse(null);
        if(transactionFromDb != null){
            newTransactionData = TransactionDto.toEntity(transactionDto);
            transactionFromDb = newTransactionData;
            transactionFromDb = transactionRepository.save(transactionFromDb);
            transactionUpdated = TransactionDto.fromEntity(transactionFromDb);
        }
        return transactionUpdated;
    }

}
