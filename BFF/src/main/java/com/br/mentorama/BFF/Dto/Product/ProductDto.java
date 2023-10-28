package com.br.mentorama.BFF.Dto.Product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {

    private String description;
    private Integer quantity;
    private BigDecimal price;
}
