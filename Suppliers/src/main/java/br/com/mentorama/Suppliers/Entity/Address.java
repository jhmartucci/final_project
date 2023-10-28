package br.com.mentorama.Suppliers.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "corp_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(name = "zip_code", nullable = false)
    private String zipCode;
    @Column(nullable = false)
    private String country;
    @ManyToOne(fetch = FetchType.LAZY)
    private Suppliers suppliers;
}
