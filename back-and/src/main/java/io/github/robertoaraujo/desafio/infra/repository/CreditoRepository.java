package io.github.robertoaraujo.desafio.infra.repository;

import io.github.robertoaraujo.desafio.infra.model.Credito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Long> {
    List<Credito> findByNumeroNfse(String numeroNfse);

    @Query(nativeQuery = true, value = "SELECT * FROM credito WHERE numero_nfse = ?1 LIMIT 1")
    Credito buscaNumeroNfse(String numeroNfse);

    Page<Credito> findAllBy(Pageable pageable);
}
