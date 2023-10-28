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
@Table(name = "suppliers")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "corporate_name", nullable = false)
    private String corporateName;
    @Column(nullable = false)
    private String cnpj;
    @Column(name = "corporate_contact_name", nullable = false)
    private String corporateContactName;
    @Column(name = "corporate_contact_number")
    private String corporateContactNumber;
    @Column(nullable = false)
    private String email;
}
