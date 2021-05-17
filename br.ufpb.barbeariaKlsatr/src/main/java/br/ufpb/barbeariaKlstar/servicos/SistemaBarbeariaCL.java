package br.ufpb.barbeariaKlstar.servicos;

import br.ufpb.barbeariaKlstar.entidades.Cliente;
import br.ufpb.barbeariaKlstar.entidades.Funcionario;
import br.ufpb.barbeariaKlstar.entidades.Produto;

import java.util.HashMap;
import java.util.Map;

public class SistemaBarbeariaCL implements SistemaBarbearia{


    private Map<String, Funcionario> funcionarios;
    private Map<String, Produto> produtos;
    private Map<String, Cliente> clientes;


    public SistemaBarbeariaCL() {
        this.clientes = new HashMap<String, Cliente>();
        this.funcionarios = new HashMap<String, Funcionario>();
        this.produtos = new HashMap<String, Produto>();
    }

    @Override
    public boolean comprarProduto() {
        return false;
    }

    @Override
    public boolean cadastrarProduto() {
        return false;
    }

    @Override
    public boolean existeProduto() {
        return false;
    }

    @Override
    public boolean cadastrarFuncionario (String nome, String dataDeNascimento, String telefone, String email, String cpf) {

        if (funcionarios.size()==0) {
            Funcionario f = new Funcionario(nome, dataDeNascimento, telefone, email, cpf);
            this.funcionarios.put(cpf, f);
            return true;
        } else {
            if (this.existeFuncionario(cpf)) {
                return false;
            } else {
                Funcionario f = new Funcionario(nome, dataDeNascimento, telefone, email, cpf);
                this.funcionarios.put(cpf, new Funcionario(nome, dataDeNascimento, telefone, email, cpf));
                return true;
            }
        }
    }

    @Override
    public boolean existeFuncionario(String cpf) {
        if (this.funcionarios.containsKey(cpf)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean cadastrarCliente(String nome, String telefone, String email) {

        if (existeCliente(telefone)) {
            return false;
        } else {
            Cliente c = new Cliente(nome, telefone, email);
            this.clientes.put(telefone, c);
            return true;
        }
    }

    @Override
    public boolean existeCliente(String telefone) {

        if(this.clientes.containsKey(telefone)) {
            return true;
        } else {
            return false;
        }
    }

}
