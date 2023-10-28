package com.br.mentorama.BFF.Dto.Supplier;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressSuppliersDto {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private UUID suppliersId;
}
