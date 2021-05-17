package br.ufpb.barbeariaKlstar.servicos;

import br.ufpb.barbeariaKlstar.entidades.Cliente;
import br.ufpb.barbeariaKlstar.entidades.Funcionario;
import br.ufpb.barbeariaKlstar.entidades.Produto;

import java.util.HashMap;
import java.util.Map;

public class SistemaBarbeariCL {

    private Map<String, Cliente> clientes;
    private Map<String, Funcionario> funcionarios;
    private Map<String, Produto> produtos;

    public SistemaBarbeariCL () {
        this.clientes = new HashMap<String, Cliente>();
        this.funcionarios = new HashMap<String, Funcionario>();
        this.produtos = new HashMap<String, Produto>();
    }

    public boolean cadastrarFuncionario (Funcionario funcionario) {
        if (funcionarios.size()==0) {
            this.funcionarios.put(funcionario.getCpf(), funcionario);
            return true;
        } else {
            if (this.existeFuncionario(funcionario)) {
                return false;
            } else {
                this.funcionarios.put(funcionario.getCpf(), funcionario);
                return true;
            }
        }
    }

    public boolean existeFuncionario(Funcionario funcionario) {
        if (this.funcionarios.containsKey(funcionario.getCpf())) {
            return true;
        } else {
            return false;
        }
    }

}
