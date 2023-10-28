package com.br.mentorama.BFF.Dto.Customer;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String name;
    private String cpf;
    private String rg;
    private String email;
    private String phoneNumber;
    
}
