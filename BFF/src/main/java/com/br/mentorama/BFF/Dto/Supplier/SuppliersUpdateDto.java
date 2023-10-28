package com.br.mentorama.BFF.Dto.Supplier;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SuppliersUpdateDto {

    private UUID id;
    private String corporateName;
    private String cnpj;
    private String corporateContactName;
    private String corporateContactNumber;
    private String email;

}
