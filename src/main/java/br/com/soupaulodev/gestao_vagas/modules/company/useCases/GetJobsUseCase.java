package br.com.soupaulodev.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soupaulodev.gestao_vagas.modules.company.entities.JobEntity;
import br.com.soupaulodev.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class GetJobsUseCase {
    
    @Autowired
    private JobRepository jobRepository;

    public Iterable<JobEntity> execute() {
        return this.jobRepository.findAll();
    }
}
