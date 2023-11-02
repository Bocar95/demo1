package com.example.demo.service.interfaces;

import com.example.demo.dto.TransactionDto;

import java.util.List;

public interface TransactionInterface {

    List<TransactionDto> getAllTransaction();

    TransactionDto getTransactionById(Long id);

    TransactionDto addTransaction(TransactionDto transactionDto);

    TransactionDto updateTransaction(TransactionDto transactionDto);

}
