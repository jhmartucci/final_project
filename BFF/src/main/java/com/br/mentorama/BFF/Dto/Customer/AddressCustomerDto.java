package com.br.mentorama.BFF.Dto.Customer;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressCustomerDto {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private UUID customerId;
}
