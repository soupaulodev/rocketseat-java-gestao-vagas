package br.com.soupaulodev.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.soupaulodev.gestao_vagas.modules.company.entities.JobEntity;
import br.com.soupaulodev.gestao_vagas.modules.company.useCases.CreateJobUseCase;
import br.com.soupaulodev.gestao_vagas.modules.company.useCases.GetJobsUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {
    
    @Autowired
    private GetJobsUseCase getJobsUseCase;
    @Autowired
    private CreateJobUseCase createJobUseCase;

    @GetMapping("/")
    public ResponseEntity<Object> getJobs() {
        try {
            var result = getJobsUseCase.execute();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody JobEntity jobEntity) {
        try {
            var result = createJobUseCase.execute(jobEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
