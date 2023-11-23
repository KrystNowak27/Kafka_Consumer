package org.nowak.repository;
import org.nowak.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    boolean existsByEmail(String email);

    List<Client> findAll();

    List<Client> findByCreatedAtBefore(LocalDateTime date);
    void deleteByCreatedAtBefore(LocalDateTime date);
}
