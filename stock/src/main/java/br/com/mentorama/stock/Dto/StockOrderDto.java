package br.com.mentorama.stock.Dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockOrderDto {

    private UUID StockId;
    private UUID productId;
    private String description;
    private Integer quantity;
}
