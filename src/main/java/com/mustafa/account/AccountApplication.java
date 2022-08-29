package com.mustafa.account;

import com.mustafa.account.model.Customer;
import com.mustafa.account.repository.CustomerRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public AccountApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String description,
                                 @Value("${application-version}") String version) {

        return new OpenAPI().info(new Info().title("Account API").version(version).description(description).license(new License().name("Account API Licence")));

    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Override
    public void run(String... args) {
        Customer customer = customerRepository.save(new Customer("Mustafa", "Kılıç"));
        Customer customer1 = customerRepository.save(new Customer("Çınar", "Kılıç"));

        System.out.println(customer);
        System.out.println(customer1);

    }

}
