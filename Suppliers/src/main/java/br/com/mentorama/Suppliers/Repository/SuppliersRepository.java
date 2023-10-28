package br.com.mentorama.Suppliers.Repository;

import br.com.mentorama.Suppliers.Entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, UUID> {
}
