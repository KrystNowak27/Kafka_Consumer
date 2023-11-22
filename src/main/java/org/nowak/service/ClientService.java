package org.nowak.service;

import lombok.RequiredArgsConstructor;
import org.nowak.dto.ClientMapper;
import org.nowak.dto.ClientRequest;
import org.nowak.repository.entity.Client;
import org.nowak.repository.ClientSpringDataJPARepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientSpringDataJPARepository clientRepository;
    private final ClientMapper mapper;

    public boolean doesEmailExist(String email) {
        return clientRepository.existsByEmail(email);
    }

    public void save(ClientRequest clientRequest) {
        Client client = mapper.map(clientRequest);
        if (!doesEmailExist(clientRequest.getEmail())) {
            clientRepository.save(client);
        } else {
            throw new IllegalArgumentException("Client with the same email already exists.");
        }
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    @Scheduled(cron = "0 9 13 * * ?")
    @Transactional
    public void cleanupOldRecords() {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minus(30, ChronoUnit.MINUTES);
        clientRepository.deleteByCreatedAtBefore(oneMonthAgo);
    }

}

