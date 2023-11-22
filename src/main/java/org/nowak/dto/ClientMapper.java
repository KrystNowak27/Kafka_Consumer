package org.nowak.dto;

import org.nowak.repository.entity.Client;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class ClientMapper {
    public Client map(ClientRequest clientRequest) {
        return Client.builder()
                .name(clientRequest.getName())
                .surname(clientRequest.getSurname())
                .email(clientRequest.getEmail())
                .balance(clientRequest.getBalance())
                .createdAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build();
    }
}