package com.mustafa.account.dto.converter;

import com.mustafa.account.dto.CustomerAccountDto;
import com.mustafa.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter transactionDtoConverter;

    public CustomerAccountDtoConverter(TransactionDtoConverter transactionDtoConverter) {
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public CustomerAccountDto convert(Account account) {
        return new CustomerAccountDto(Objects.requireNonNull(account.getId()), account.getBalance(),
                account.getTransaction().stream().map(transactionDtoConverter::convertToTransactionDto).collect(Collectors.toSet()),
                account.getCreationDate());
    }
}
