package br.com.mentorama.Order.Dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    private UUID StockId;
    private UUID productId;
    private String description;
    private Integer quantity;
}
