package com.example.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
class UserControllerTest {

    @Inject
    @Client("/users") // Substituir pelo endpoint correto do controller
    HttpClient client;

    @Test
    void testCreateUser() {
        // Mock do payload para criação de usuário
        var userPayload = new UserDTO("Pedro Nunes", "pedro.nunes@example.com", "password123");

        HttpRequest<UserDTO> request = HttpRequest.POST("/", userPayload);
        HttpResponse<UserDTO> response = client.toBlocking().exchange(request, UserDTO.class);

        assertEquals(201, response.getStatus().getCode());
        UserDTO createdUser = response.body();
        assertNotNull(createdUser);
        assertEquals("Pedro Nunes", createdUser.getName());
        assertEquals("pedro.nunes@example.com", createdUser.getEmail());
    }
}
