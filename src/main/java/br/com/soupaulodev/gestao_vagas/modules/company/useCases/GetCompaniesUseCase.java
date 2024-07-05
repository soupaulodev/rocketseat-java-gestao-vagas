package br.com.soupaulodev.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soupaulodev.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.soupaulodev.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class GetCompaniesUseCase {
    
    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<CompanyEntity> execute() {
        return this.companyRepository.findAll();
    }
}
