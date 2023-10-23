package org.nowak.service;

import lombok.RequiredArgsConstructor;
import org.nowak.dto.ClientRequest;
import org.nowak.repository.entity.Client;
import org.nowak.repository.entity.ClientSpringDataJPARepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientSpringDataJPARepository clientRepository;
    private final ClientMapper mapper;

    public void save(ClientRequest clientRequest){
        Client client = mapper.map(clientRequest);
        clientRepository.save(client);

    }
}
