package io.github.robertoaraujo.desafio.service;

import io.github.robertoaraujo.desafio.infra.dto.CreditoDto;
import io.github.robertoaraujo.desafio.infra.model.Credito;
import io.github.robertoaraujo.desafio.infra.repository.CreditoRepository;
import io.github.robertoaraujo.desafio.infra.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditoService {

    private final CreditoRepository creditoRepository;

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CreditoService(CreditoRepository creditoRepository, UsuarioRepository usuarioRepository) {
        this.creditoRepository = creditoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Page<Credito> findAll(Pageable pageable) {
        if (pageable.getPageSize() > 100) {
            throw new IllegalArgumentException("O tamanho da página não pode ser maior que 100");
        }
        if (pageable.getPageNumber() < 0) {
            throw new IllegalArgumentException("O número da página não pode ser menor que 0");
        }
        if (pageable.getPageSize() == 0) {
            throw new IllegalArgumentException("O tamanho da página não pode ser 0");
        }
        return creditoRepository.findAllBy(pageable);
    }

    public Credito criarCredito(CreditoDto credito) {
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
        novoCredito.setUsuario(usuarioRepository.getReferenceById(credito.getUsuarioId()));

        return creditoRepository.save(novoCredito);
    }

    public List<Credito> findAllNumeroNfse(String numeroNfse) {
        return creditoRepository.findByNumeroNfse(numeroNfse);
    }

    public Credito findByNumeroNfse(String numeroNfse) {
        return creditoRepository.buscaNumeroNfse(numeroNfse);
    }
}
