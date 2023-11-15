package org.nowak.service;

import lombok.RequiredArgsConstructor;
import org.nowak.dto.ClientMapper;
import org.nowak.dto.ClientRequest;
import org.nowak.repository.entity.Client;
import org.nowak.repository.ClientSpringDataJPARepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientSpringDataJPARepository clientRepository;
    private final ClientMapper mapper;

    public void save(ClientRequest clientRequest) {
        Client client = mapper.map(clientRequest);
        clientRepository.save(client);

    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}

