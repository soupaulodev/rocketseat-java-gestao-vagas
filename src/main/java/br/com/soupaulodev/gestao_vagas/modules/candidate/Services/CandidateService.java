package br.com.soupaulodev.gestao_vagas.modules.candidate.Services;

import org.springframework.stereotype.Service;

import br.com.soupaulodev.gestao_vagas.modules.candidate.entities.CandidateEntity;

@Service
public class CandidateService {
    public CandidateEntity save(CandidateEntity candidate) {
        return candidate;
    }
}
