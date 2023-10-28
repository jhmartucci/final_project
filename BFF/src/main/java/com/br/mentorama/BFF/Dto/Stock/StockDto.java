package com.br.mentorama.BFF.Dto.Stock;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    private UUID productId;
    private Integer quantity;
}
