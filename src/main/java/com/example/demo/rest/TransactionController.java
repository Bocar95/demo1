package com.example.demo.rest;

import com.example.demo.dto.TransactionDto;
import com.example.demo.service.interfaces.TransactionInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionInterface transactionInterface;

    public TransactionController(TransactionInterface transactionInterface) {
        this.transactionInterface = transactionInterface;
    }

    @GetMapping("/getAll")
    List<TransactionDto> getAllTransaction(){
        return transactionInterface.getAllTransaction();
    }

    @GetMapping("/getById/{id}")
    TransactionDto getTransactionById(@PathVariable Long id){
        return transactionInterface.getTransactionById(id);
    }

    @PostMapping("/add")
    TransactionDto addTransaction(@RequestBody TransactionDto transactionDto){
        return transactionInterface.addTransaction(transactionDto);
    }

}
