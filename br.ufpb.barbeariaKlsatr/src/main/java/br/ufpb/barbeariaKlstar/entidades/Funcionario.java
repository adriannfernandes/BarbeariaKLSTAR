package br.ufpb.barbeariaKlstar.entidades;

public class Funcionario {
    private String nome;
    private String dataDeNascimento;
    private String telefone;
    private String email;
    private String cpf;

    public Funcionario(String nome, String dataDeNascimento, String telefone, String email, String cpf) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public Funcionario() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String toString() {
        return "O funcionario " + this.nome + ", com data de nascimento " + this.dataDeNascimento + ", telefone " + this.telefone + ", E-mail " + this.email + " e com CPF " + this.cpf;
    }

}
