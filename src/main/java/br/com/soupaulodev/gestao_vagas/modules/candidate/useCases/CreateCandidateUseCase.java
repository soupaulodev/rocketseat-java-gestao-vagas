package br.com.soupaulodev.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soupaulodev.gestao_vagas.exceptions.UserFoundException;
import br.com.soupaulodev.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.soupaulodev.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidate) {
        this.candidateRepository
            .findByUsernameOrEmail(
                candidate.getUsername(), 
                candidate.getEmail()
            ).ifPresent((user) -> {
                throw new UserFoundException();
            });


        CandidateEntity candidateToCreate = candidate;
        candidateToCreate.setId(UUID.randomUUID());

        return this.candidateRepository.save(candidate);
    }
}
