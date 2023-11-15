package org.nowak.controller;

import lombok.RequiredArgsConstructor;
import org.nowak.repository.entity.Client;
import org.nowak.service.ClientService;
import org.nowak.service.KafkaConsumerService;
//import org.nowak.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.nowak.dto.ClientRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class ClientController {
    private final ClientService service;
    private final KafkaConsumerService kafkaConsumer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody ClientRequest client) {
        kafkaConsumer.consumeAndSave(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        Client client = service.getClientById(id);

        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
