package Proj.Cad;

import java.util.InputMismatchException;

public class Pessoa {
    private String nome;
    private String cpf;


    public String getNome() {
        return nome;
    }
    public String setNome(String nome) {
        if(!nome.matches("[A-Z]")){
            throw new NullPointerException("\nNome inválido, tente novamente");
        }
        this.nome = nome;
        return nome;
        
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {

        if(!cpf.matches("\\d{11}")){
            throw new InputMismatchException("\nCpf invalido, por favor tente novamente!");
        }
        this.cpf = cpf;
    }

    
}