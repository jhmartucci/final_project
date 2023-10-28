package com.br.mentorama.BFF.Dto.Order;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private UUID productId;
    private Integer saleQuantity;
}
