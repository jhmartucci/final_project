package br.com.mentorama.Suppliers.Dto;

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
