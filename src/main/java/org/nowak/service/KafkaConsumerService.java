package org.nowak.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nowak.dto.ClientRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {
    private final ClientService clientService;

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeAndSave(ClientRequest clientRequest) {
        log.info(String.format("Json message received -> %s", clientRequest.toString()));
       clientService.save(clientRequest);
    }
}