package com.br.mentorama.BFF.Dto.Supplier;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SuppliersDto {

    private String corporateName;
    private String cnpj;
    private String corporateContactName;
    private String corporateContactNumber;
    private String email;

}
