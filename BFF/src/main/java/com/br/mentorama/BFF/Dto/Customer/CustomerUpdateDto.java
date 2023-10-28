package com.br.mentorama.BFF.Dto.Customer;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateDto {

    private UUID id;
    private String name;
    private String cpf;
    private String rg;
    private String email;
    private String phoneNumber;
    
}
