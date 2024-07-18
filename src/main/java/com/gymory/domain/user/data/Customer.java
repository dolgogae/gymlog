package com.gymory.domain.user.data;

import com.gymory.domain.user.dto.CustomerDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("CUSTOMER")
public class Customer extends UserEntity{

    // TODO: justify columns
    private String exampleColumns;

    @Builder
    private Customer(String username, String email, String password, String exampleColumns) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.exampleColumns = exampleColumns;
    }

    public static Customer create(CustomerDto customerDto){
        return Customer.builder()
                .username(customerDto.getUsername())
                .email(customerDto.getEmail())
                .password(customerDto.getPassword())
                .exampleColumns(customerDto.getExampleColumns())
                .build();
    }
}
