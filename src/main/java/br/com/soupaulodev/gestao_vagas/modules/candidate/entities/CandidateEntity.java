package br.com.soupaulodev.gestao_vagas.modules.candidate.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
    
    @Id
    @Generated(value = "UUID")
    private UUID id;
    
    private String name;

    @NotBlank
    @Pattern(regexp = "^\\S+$", message = "O campo [username] não pode conter espaços")
    private String username;

    @Email(message = "O campo [email] deve conter um email válido")
    private String email;

    @Length(min = 8, message = "O campo [password] deve conter pelo menos 8 caracteres")
    private String password;
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
