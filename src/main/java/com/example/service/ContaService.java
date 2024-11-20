package com.example.service;

import com.example.dto.CadastroDTO;
import com.example.dto.TransferenciaDTO;
import com.example.model.Conta;
import com.example.repository.ContaRepository;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

@Singleton
@Transactional
public class ContaService {
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta criarConta(CadastroDTO cadastroDTO) {
        Conta conta = new Conta();
        conta.setTitular(cadastroDTO.getTitular());
        conta.setEmail(cadastroDTO.getEmail());
        conta.setSenha(cadastroDTO.getSenha());
        Conta savedConta = contaRepository.save(conta);

        new Thread(() -> {
            try {
                Thread.sleep(60000);
                savedConta.setSaldo(100.0);
                contaRepository.update(savedConta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return savedConta;
    }

    public void transferir(TransferenciaDTO transferenciaDTO) {
        Conta origem = contaRepository.findById(transferenciaDTO.getIdOrigem())
                .orElseThrow(() -> new IllegalArgumentException("Conta de origem não encontrada"));
        Conta destino = contaRepository.findById(transferenciaDTO.getIdDestino())
                .orElseThrow(() -> new IllegalArgumentException("Conta de destino não encontrada"));

        if (origem.getSaldo() < transferenciaDTO.getValor()) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        origem.setSaldo(origem.getSaldo() - transferenciaDTO.getValor());
        destino.setSaldo(destino.getSaldo() + transferenciaDTO.getValor());

        contaRepository.update(origem);
        contaRepository.update(destino);
    }

    public Double consultarSaldo(Long id) {
        return contaRepository.findById(id).map(Conta::getSaldo).orElse(0.0);
    }
}
