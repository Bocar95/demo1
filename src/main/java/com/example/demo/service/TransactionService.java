package com.example.demo.service;

import com.example.demo.dto.TransactionDto;
import com.example.demo.entities.Transaction;
import com.example.demo.repositories.TransactionRepository;
import com.example.demo.service.interfaces.TransactionInterface;
import org.modelmapper.ModelMapper;
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
        ModelMapper modelMapper = new ModelMapper();
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        List<Transaction> transactionList = transactionRepository.findAll();
        if(transactionList.size() > 0){
            transactionList.forEach(transact -> {
                transactionDtoList.add(modelMapper.map(transact, TransactionDto.class));
            });
        }
        return transactionDtoList;
    }

    @Override
    public TransactionDto getTransactionById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        TransactionDto transactionDto = new TransactionDto();
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if(transaction != null){
            transactionDto = modelMapper.map(transaction, TransactionDto.class);
        }
        return transactionDto;
    }

    @Override
    public TransactionDto addTransaction(TransactionDto transactionDto) {
        ModelMapper modelMapper = new ModelMapper();
        LocalDateTime now = LocalDateTime.now();
        TransactionDto transactionDtoSaved = new TransactionDto();
        transactionDto.setDateTransaction(now);
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        transaction = transactionRepository.save(transaction);
        transactionDtoSaved = modelMapper.map(transaction, TransactionDto.class);

        return transactionDtoSaved;
    }

    @Override
    public TransactionDto updateTransaction(TransactionDto transactionDto) {
        return null;
    }

}
