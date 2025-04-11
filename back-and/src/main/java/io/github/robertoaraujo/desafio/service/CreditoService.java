package io.github.robertoaraujo.desafio.service;

import io.github.robertoaraujo.desafio.infra.dto.CreditoDto;
import io.github.robertoaraujo.desafio.infra.model.Credito;
import io.github.robertoaraujo.desafio.infra.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditoService {

    private final CreditoRepository creditoRepository;

    @Autowired
    public CreditoService(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }

    public Page<Credito> findAll(Pageable pageable) {
        return creditoRepository.findAllBy(pageable);
    }


    public List<Credito> criarCredito(CreditoDto credito) {
        Credito novoCredito = new Credito();
        novoCredito.setNumeroCredito(credito.getNumeroCredito());
        novoCredito.setNumeroNfse(credito.getNumeroNfse());
        novoCredito.setDataConstituicao(credito.getDataConstituicao());
        novoCredito.setValorIssqn(credito.getValorIssqn());
        novoCredito.setTipoCredito(credito.getTipoCredito());
        novoCredito.setSimplesNacional(credito.isSimplesNacional());
        novoCredito.setAliquota(credito.getAliquota());
        novoCredito.setValorFaturado(credito.getValorFaturado());
        novoCredito.setValorDeducao(credito.getValorDeducao());
        novoCredito.setBaseCalculo(credito.getBaseCalculo());

        creditoRepository.save(novoCredito);
        return creditoRepository.findAll();
    }

    public List<Credito> findAllNumeroNfse(String numeroNfse) {
        return creditoRepository.findByNumeroNfse(numeroNfse);
    }

    public Credito findByNumeroNfse(String numeroNfse) {
        return creditoRepository.buscaNumeroNfse(numeroNfse);
    }
}
