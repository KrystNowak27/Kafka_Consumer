package org.nowak.service;

import org.nowak.dto.ClientRequest;
import org.nowak.repository.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client map(ClientRequest clientRequest){
        return Client.builder()
                .name(clientRequest.getName())
                .surname(clientRequest.getSurname())
                .email(clientRequest.getEmail())
                .balance(clientRequest.getBalance())
                .build();
    }
}
