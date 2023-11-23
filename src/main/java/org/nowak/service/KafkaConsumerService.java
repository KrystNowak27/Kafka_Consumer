package org.nowak.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nowak.dto.ClientDto;
import org.nowak.dto.ClientRequest;
import org.nowak.mapper.ClientMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeAndSave(ClientDto clientDto) {
        clientService.save(clientDto);
        log.info(String.format("Json message received -> %s", clientDto.toString()));
    }
}