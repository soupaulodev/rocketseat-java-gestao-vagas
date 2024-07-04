package br.com.soupaulodev.gestao_vagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.soupaulodev.gestao_vagas.modules.candidate.Services.CandidateService;
import br.com.soupaulodev.gestao_vagas.modules.candidate.entities.CandidateEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/")
    public ResponseEntity<CandidateEntity> create(@Valid @RequestBody CandidateEntity candidate) {
        CandidateEntity candidateCreated = candidateService.save(candidate);

        return ResponseEntity.ok(candidateCreated);
    }
}
