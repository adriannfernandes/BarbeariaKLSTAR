package br.ufpb.barbeariaKlstar.servicos;

import br.ufpb.barbeariaKlstar.entidades.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SistemaBarbeariaCL implements SistemaBarbearia{


    private HashMap<String, Funcionario> funcionarios;
    private HashMap<String, Produto> produtos;
    private HashMap<String, Cliente> clientes;
    private HashMap<String, Horario> horariosAgendados;
    private File FILE_CLIENTES = new File("clientes.txt");
    private File FILE_PRODUTOS = new File("produtos.txt");
    private File FILE_FUNCIONARIOS = new File("funcionarios.txt");


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
    @Override
    public boolean gravarDados(){

        try {
            FileWriter fileWriterC = new FileWriter(FILE_CLIENTES);
            BufferedWriter bwC = new BufferedWriter(fileWriterC);
            for (Cliente cliente : clientes.values()) {
                String stringClienteComposta = cliente.getNome() +"#"+ cliente.getTelefone() +"#"+ cliente.getEmail();
                bwC.write(stringClienteComposta);
                bwC.newLine();
            }
            bwC.flush();
            fileWriterC.close();

            FileWriter fileWriterP = new FileWriter(FILE_PRODUTOS);
            BufferedWriter bwP = new BufferedWriter(fileWriterP);
            
            String stringProdutoComposto;
            for (Produto produto : produtos.values()) {
                stringProdutoComposto = produto.getNome() + "#" + produto.getPreco();
                //stringProdutoComposto = produto.getNome() +"#"+ produto.getPreco() +"#"+ produto.getCodigo() +"#"+ produto.getCategoriaVenda() +"#"+ produto.getQuantidadeProdutoEstoque() +"#"+ produto.getDescricao();
                
                bwP.write(stringProdutoComposto);
                bwP.newLine();
            }

            bwP.flush();
            fileWriterP.close();

            FileWriter fileWriterF = new FileWriter(FILE_FUNCIONARIOS);
            BufferedWriter bwF = new BufferedWriter(fileWriterF);
            for (Funcionario funcionario : funcionarios.values()) {
                String stringFuncionarioComposta = funcionario.getNome() +"#"+ funcionario.getDataDeNascimento() +"#"+ funcionario.getTelefone() +"#"+ funcionario.getEmail() + "#" + funcionario.getCpf();
                bwF.write(stringFuncionarioComposta);
                bwF.newLine();
            }
            bwF.flush();
            fileWriterF.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            return false;
        }
    }

    @Override
    public void recuperarDados(){

        try{
            FileReader fileReaderC = new FileReader(FILE_CLIENTES);
            BufferedReader brC = new BufferedReader(fileReaderC);
            String lineC;
            while((lineC = brC.readLine()) != null){
                String nome, telefone, email;
                String vetor [] = lineC.split("#");
                nome = vetor[0];
                telefone = vetor[1];
                email = vetor[2];
                Cliente c = new Cliente(nome, telefone, email); 
                this.clientes.put(c.getTelefone(), c );        
            }

            FileReader fileReaderP = new FileReader(FILE_PRODUTOS);
            BufferedReader brP = new BufferedReader(fileReaderP);
            String lineP;
            while((lineP = brP.readLine()) != null){
                String nome;
                Double preco;
                String codigo;
                String categoriaVenda;
                int quantidadeProdutosEstoque;
                String descricao;
                
                String vetor [] = lineP.split("#");
                nome = vetor[0];
                preco = Double.parseDouble(vetor[1]);
                codigo = vetor[2];
                categoriaVenda = vetor[3];
                quantidadeProdutosEstoque = Integer.parseInt(vetor[4]);
                descricao = vetor[5];
                ProdutoFisico p = new ProdutoFisico(nome, preco, codigo, categoriaVenda, quantidadeProdutosEstoque, descricao);
                this.produtos.put(p.getCodigo(), p);
                
            }

            FileReader fileReaderF = new FileReader(FILE_FUNCIONARIOS);
            BufferedReader brF = new BufferedReader(fileReaderF);
            String lineF;
            while((lineF = brF.readLine()) != null){
                String nome, dataDeNascimento, telefone, email, cpf;
                String vetor [] = lineF.split("#");
                nome = vetor[0];
                dataDeNascimento = vetor[1];
                telefone = vetor[2];
                email = vetor[3];
                cpf = vetor[4];
                Funcionario f = new Funcionario(nome, dataDeNascimento, telefone, email, cpf);
                this.funcionarios.put(f.getCpf(), f);        
            }  

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }



}
