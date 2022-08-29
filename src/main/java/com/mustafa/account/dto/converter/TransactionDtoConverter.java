package com.mustafa.account.dto.converter;

import com.mustafa.account.dto.TransactionDto;
import com.mustafa.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    public TransactionDto convertToTransactionDto(Transaction transaction){

        return new TransactionDto(transaction.getId(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getTransactionDate());
    }
}
