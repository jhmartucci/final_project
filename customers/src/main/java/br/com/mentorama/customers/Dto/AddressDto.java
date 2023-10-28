package br.com.mentorama.customers.Dto;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private UUID customerId;
}
