package org.nowak.controller;

import lombok.RequiredArgsConstructor;
import org.nowak.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.nowak.dto.ClientRequest;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @PostMapping(path = "/api/user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createClient(@RequestBody ClientRequest client){
        service.save(client);
    }
}