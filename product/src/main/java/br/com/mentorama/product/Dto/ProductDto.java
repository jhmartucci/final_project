package br.com.mentorama.product.Dto;

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
