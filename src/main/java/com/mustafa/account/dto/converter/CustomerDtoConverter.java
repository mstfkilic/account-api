package com.mustafa.account.dto.converter;

import com.mustafa.account.dto.AccountCustomerDto;
import com.mustafa.account.dto.CustomerDto;
import com.mustafa.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter customerAccountDtoConverter) {
        this.customerAccountDtoConverter = customerAccountDtoConverter;
    }

    public AccountCustomerDto convertToAccountCustomer(Optional<Customer> customer) {
        return customer.map(c -> new AccountCustomerDto(c.getId(), c.getName(), c.getSurname())).orElseThrow(null);
    }

    public CustomerDto convertToCustomerDto(Customer customer) {
        return new CustomerDto(customer.getId(),
                customer.getName(),
                customer.getSurname(),
                customer.getAccounts().stream().map(customerAccountDtoConverter::convert).collect(Collectors.toSet()));

    }
}
