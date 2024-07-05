package br.com.soupaulodev.gestao_vagas.modules.company.repositories;

import java.util.UUID;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.soupaulodev.gestao_vagas.modules.company.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
    Optional<JobEntity> findByCompanyId(UUID id);
}
