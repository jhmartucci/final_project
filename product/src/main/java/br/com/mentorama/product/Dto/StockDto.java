package br.com.mentorama.product.Dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    private UUID productId;
    private String description;
    private Integer quantity;
}
