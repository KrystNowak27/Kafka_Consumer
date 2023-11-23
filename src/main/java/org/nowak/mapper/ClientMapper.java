package org.nowak.mapper;

import org.nowak.dto.ClientDto;
import org.nowak.dto.ClientRequest;
import org.nowak.entity.Client;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class ClientMapper {
    public Client map(ClientDto clientDto) {
        return Client.builder()
                .name(clientDto.getName())
                .surname(clientDto.getSurname())
                .email(clientDto.getEmail())
                .balance(clientDto.getBalance())
                .createdAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build();
    }
    public ClientDto mapToDto(ClientRequest clientRequest) {
        return ClientDto.builder()
                .name(clientRequest.getName())
                .surname(clientRequest.getSurname())
                .email(clientRequest.getEmail())
                .balance(clientRequest.getBalance())
                .createdAt(clientRequest.getCreatedAt())
                .build();
    }

}