package org.nowak.service;
import org.nowak.repository.ClientSpringDataJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class DatabaseCleanupScheduler {

    private ClientSpringDataJPARepository repository;

    @Autowired
    public DatabaseCleanupScheduler(ClientSpringDataJPARepository repository) {
        this.repository = repository;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void cleanupOldRecords() {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minus(1, ChronoUnit.MONTHS);
        repository.deleteByCreatedAtBefore(oneMonthAgo);
    }
}
