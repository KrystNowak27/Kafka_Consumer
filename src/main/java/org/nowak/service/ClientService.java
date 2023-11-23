package org.nowak.service;

import lombok.RequiredArgsConstructor;
import org.nowak.dto.ClientDto;
import org.nowak.dto.ClientRequest;
import org.nowak.exceptions.ClientAlreadyExistsException;
import org.nowak.exceptions.NoIdClientInDatabaseException;
import org.nowak.mapper.ClientMapper;
import org.nowak.entity.Client;
import org.nowak.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper mapper;

    public boolean emailExist(String email) {
        return clientRepository.existsByEmail(email);
    }

    public void save(ClientDto clientDto) {
        Client client = mapper.map(clientDto);
        if (emailExist(clientDto.getEmail())) {
            throw new ClientAlreadyExistsException("Client with email: " + clientDto.getEmail() + "already exists.");
        }
        clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(()->
                new NoIdClientInDatabaseException("Client with id: "+ id +" no exist"));
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    @Transactional
    public void cleanupOldRecords(LocalDateTime oneMonthAgo) {
        clientRepository.deleteByCreatedAtBefore(oneMonthAgo);
    }

}

