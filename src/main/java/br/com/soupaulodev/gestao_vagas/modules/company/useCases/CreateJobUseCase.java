package br.com.soupaulodev.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soupaulodev.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.soupaulodev.gestao_vagas.modules.company.entities.JobEntity;
import br.com.soupaulodev.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {
    
    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        var companyExists = this.jobRepository.findByCompanyId(jobEntity.getCompanyId()).isEmpty();
        if (companyExists) {
            throw new CompanyNotFoundException();
        }
        
        return this.jobRepository.save(jobEntity);
    }
}
