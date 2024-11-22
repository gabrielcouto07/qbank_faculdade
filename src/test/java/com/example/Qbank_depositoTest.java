package com.example.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class DepositControllerTest {

    @Inject
    @Client("/accounts") // Substituir pelo endpoint correto
    HttpClient client;

    @Test
    void testDeposit() {
        // Mock do payload para depósito
        var depositPayload = new DepositDTO(1L, 100.00); // ID da conta e valor do depósito

        HttpRequest<DepositDTO> request = HttpRequest.POST("/deposit", depositPayload);
        HttpResponse<AccountDTO> response = client.toBlocking().exchange(request, AccountDTO.class);

        assertEquals(200, response.getStatus().getCode());
        AccountDTO updatedAccount = response.body();
        assertEquals(100.00, updatedAccount.getBalance()); // Verifique o saldo atualizado
    }
}
