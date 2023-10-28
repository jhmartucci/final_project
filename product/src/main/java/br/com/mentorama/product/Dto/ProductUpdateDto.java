package br.com.mentorama.product.Dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductUpdateDto {

    private UUID id;
    private String description;
    private Integer quantity;
    private BigDecimal price;
}
