package br.com.soupaulodev.gestao_vagas.modules.company.repositories;

import java.util.UUID;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.soupaulodev.gestao_vagas.modules.company.entities.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    
    Optional<CompanyEntity> findByCnpjOrUsernameOrEmail( String cnpj, String username, String email );
}
