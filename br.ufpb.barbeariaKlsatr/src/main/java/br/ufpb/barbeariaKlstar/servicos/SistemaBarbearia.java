package br.ufpb.barbeariaKlstar.servicos;

import br.ufpb.barbeariaKlstar.entidades.Cliente;
import br.ufpb.barbeariaKlstar.entidades.Funcionario;
import br.ufpb.barbeariaKlstar.entidades.Horario;
import br.ufpb.barbeariaKlstar.entidades.Produto;

import java.util.Collection;
import java.util.HashMap;

public interface SistemaBarbearia {
    public boolean comprarProduto();

    public  boolean cadastraProduto(String nome, double preco, String codigo, String categoriaPrecoVenda, int quantidadeProdutoEstoque, String descricao);

    public boolean existeProduto(String codigo);

    public Collection<Produto> pesquisarProdutosPeloNome(String nome);

    public HashMap<String, Cliente> pesquisarTodosClientes();

    public boolean cadastrarFuncionario(String nome, String dataDeNascimento, String telefone, String email, String cpf);

    public boolean existeFuncionario(String cpf);

    public boolean agendarHorario(String hora, Horario horario);

    public Collection<Funcionario> pesquisaFuncionarioPorNome(String nome);

    public boolean cadastrarCliente(String nome, String telefone, String email);

    public boolean existeCliente(String telefone);


    public Cliente pesquisarCliente(String telefone);

}
