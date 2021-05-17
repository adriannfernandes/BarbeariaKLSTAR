package br.ufpb.barbeariaKlstar.servicos;

public interface SistemaBarbearia {
    public boolean comprarProduto();

    public boolean cadastrarProduto();

    public boolean existeProduto();

    public boolean cadastrarFuncionario(String nome, String dataDeNascimento, String telefone, String email, String cpf);

    public boolean existeFuncionario(String cpf);

    //public boolean agendarHorario();

    public boolean cadastrarCliente(String nome, String telefone, String email);

    public boolean existeCliente(String telefone);
}
