package com.example.controller;

import com.example.dto.CadastroDTO;
import com.example.dto.TransferenciaDTO;
import com.example.model.Conta;
import com.example.service.ContaService;

import io.micronaut.http.annotation.*;

@Controller("/conta")
public class ContaController {
    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @Post("/cadastro")
    public Conta criarConta(@Body CadastroDTO cadastroDTO) {
        return contaService.criarConta(cadastroDTO);
    }

    @Post("/transferencia")
    public void transferir(@Body TransferenciaDTO transferenciaDTO) {
        contaService.transferir(transferenciaDTO);
    }

    @Get("/saldo/{id}")
    public Double consultarSaldo(@PathVariable Long id) {
        return contaService.consultarSaldo(id);
    }
}
