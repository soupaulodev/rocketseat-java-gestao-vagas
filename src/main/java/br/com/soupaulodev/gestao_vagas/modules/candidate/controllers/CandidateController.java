package br.com.soupaulodev.gestao_vagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.soupaulodev.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.soupaulodev.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;
import br.com.soupaulodev.gestao_vagas.modules.candidate.useCases.GetCandidatesUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private GetCandidatesUseCase getCandidatesUseCase;
    
    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @GetMapping("/")
    public ResponseEntity<Object> getCandidates() {
        try {
            var result = getCandidatesUseCase.execute();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
