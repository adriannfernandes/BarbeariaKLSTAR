package br.ufpb.barbeariaKlstar.entidades;

public class ProdutoFisico extends Produto{
    private String codigo;
    private String categoriaVenda;
    private int quantidadeProdutoEstoque;
    private String descricao;

    public ProdutoFisico(String nome, double preco, String codigo, String categoriaVenda, int quantidadeProdutoEstoque, String descricao){
        super( nome, preco);
        this.codigo = codigo;
        this.categoriaVenda = categoriaVenda;
        this.quantidadeProdutoEstoque = quantidadeProdutoEstoque;
    }
    public ProdutoFisico(){

    }
    public String getCodigo(){
        return this.codigo;
    }
    public String getCategoriaVenda(){
        return this.categoriaVenda;
    }
    public int getQuantidadeProdutoEstoque(){
        return this.quantidadeProdutoEstoque;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public void setCategoriaVenda(String categoriaVenda){
        this.categoriaVenda = categoriaVenda;
    }
    public void setQuantidadeProdutoEstoque(int quantidadeProdutoEstoque){
        this.quantidadeProdutoEstoque = quantidadeProdutoEstoque;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }


}
