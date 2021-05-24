package br.ufpb.barbeariaKlstar.servicos;

import br.ufpb.barbeariaKlstar.entidades.*;

import java.util.*;

public class SistemaBarbeariaCL implements SistemaBarbearia{


    private HashMap<String, Funcionario> funcionarios;
    private HashMap<String, Produto> produtos;
    private HashMap<String, Cliente> clientes;
    private HashMap<String, Horario> horariosAgendados;


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
    public boolean cadastraProduto(String nome, double preco, String codigo, String categoriaPrecoVenda, int quantidadeProdutoEstoque, String descricao){
        ProdutoFisico produto = new ProdutoFisico( nome, preco, codigo, categoriaPrecoVenda, quantidadeProdutoEstoque, descricao);
        if(!produtos.containsKey(produto.getCodigo())){
            this.produtos.put(produto.getCodigo(), produto);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existeProduto(String codigo) {
        if (this.produtos.containsKey(codigo)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<Produto> pesquisarProdutosPeloNome(String nome) {

        Collection<Produto> produtosComNome = new ArrayList<>();

        for(String i : produtos.keySet()) {
            if(produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                produtosComNome.add(produtos.get(i));
            }
        }
        return produtosComNome;

    }

    @Override
    public HashMap<String, Cliente> pesquisarTodosClientes(){
        return this.clientes;

    }

    @Override
    public boolean cadastrarFuncionario (String nome, String dataDeNascimento, String telefone, String email, String cpf) {

        if (funcionarios.size()==0) {
            Funcionario f = new Funcionario(nome.toUpperCase(), dataDeNascimento, telefone, email, cpf);
            this.funcionarios.put(cpf, f);
            return true;
        } else {
            if (this.existeFuncionario(cpf)) {
                return false;
            } else {
                Funcionario f = new Funcionario(nome.toUpperCase(), dataDeNascimento, telefone, email, cpf);
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
    public boolean agendarHorario(String hora, Horario horario) {
        if (this.horariosAgendados.containsKey(hora)){
            return false;
        } else {
            this.horariosAgendados.put(hora, horario);
            return true;
        }
    }

    @Override
    public Collection<Funcionario> pesquisaFuncionarioPorNome(String nome) {
        Collection<Funcionario> funcionariosPorNome = new ArrayList<>();
        for (Funcionario f: this.funcionarios.values()) {
            if (f.getNome().startsWith(nome.toUpperCase())) {
                funcionariosPorNome.add(f);
            }
        }
        return funcionariosPorNome;
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

    @Override
    public Cliente pesquisarCliente(String telefone) {

        for (String i : clientes.keySet()) {
            if (clientes.get(i).getTelefone().equals(telefone)) {
                return clientes.get(i);

            }
        }
        return null;

    }

}
