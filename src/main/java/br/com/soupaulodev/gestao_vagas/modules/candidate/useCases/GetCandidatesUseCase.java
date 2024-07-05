package br.com.soupaulodev.gestao_vagas.modules.candidate.useCases;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.soupaulodev.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.soupaulodev.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@Service
public class GetCandidatesUseCase {


    @Autowired
    private CandidateRepository candidateRepository;
   
    public Iterable<CandidateEntity> execute() {
        return this.candidateRepository.findAll();
    }
}
