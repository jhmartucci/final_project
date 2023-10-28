package br.com.mentorama.stock.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "product_id", nullable = false)
    private UUID productId;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer quantity;
}
