package org.nowak.service;

import org.nowak.repository.ClientSpringDataJPARepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class DatabaseCleanupScheduler {
    private ClientSpringDataJPARepository repository;

    @Scheduled(cron = "0 0 0 * * ?")
    public void cleanupOldRecords() {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minus(1, ChronoUnit.MONTHS);
        repository.deleteByCreatedAtBefore(oneMonthAgo);
    }
}
