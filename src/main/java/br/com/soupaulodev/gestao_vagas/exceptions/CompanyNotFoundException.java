package br.com.soupaulodev.gestao_vagas.exceptions;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException() {
        super("CompanyID nao existe");
    }
}
