package com.example.controller;

import com.example.dto.CadastroDTO;
import com.example.dto.TransferenciaDTO;
import com.example.model.Conta;
import com.example.service.ContaService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

@Controller("/conta")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @Post("/cadastro")
    public HttpResponse<Conta> criarConta(@Body CadastroDTO cadastroDTO) {
        Conta novaConta = contaService.criarConta(cadastroDTO);
        return HttpResponse.created(novaConta);
    }

    @Post("/transferencia")
    public HttpResponse<Void> transferir(@Body TransferenciaDTO transferenciaDTO) {
        try {
            contaService.transferir(transferenciaDTO);
            return HttpResponse.noContent();
        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }

    @Get("/saldo/{id}")
    public HttpResponse<Double> consultarSaldo(@PathVariable Long id) {
        try {
            Double saldo = contaService.consultarSaldo(id);
            if (saldo != null) {
                return HttpResponse.ok(saldo);
            } else {
                return HttpResponse.notFound();
            }
        } catch (Exception e) {
            return HttpResponse.serverError();
        }
    }

    @Post("/deposito")
    public HttpResponse<Conta> depositar(@Body TransferenciaDTO transferenciaDTO) {
        try {
            Conta contaAtualizada = contaService.depositar(transferenciaDTO);
            return HttpResponse.ok(contaAtualizada);
        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }

    @Post("/saque")
    public HttpResponse<Conta> sacar(@Body TransferenciaDTO transferenciaDTO) {
        try {
            Conta contaAtualizada = contaService.sacar(transferenciaDTO);
            return HttpResponse.ok(contaAtualizada);
        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }
}
