package org.nowak.controller;

import lombok.RequiredArgsConstructor;
import org.nowak.dto.ClientDto;
import org.nowak.dto.ClientRequest;
import org.nowak.entity.Client;
import org.nowak.mapper.ClientMapper;
import org.nowak.service.ClientService;
import org.nowak.service.KafkaConsumerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class ClientController {
    private final ClientService service;
    private final KafkaConsumerService kafkaConsumer;
    private final ClientMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody ClientRequest clientRequest) {
        ClientDto clientDto = mapper.mapToDto(clientRequest);
        kafkaConsumer.consumeAndSave(clientDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client getClient(@PathVariable Long id) {
        Client client = service.getClientById(id);
        return client;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllClients() {
        List<Client> clients = service.getAllClients();
            return clients;

    }
}
