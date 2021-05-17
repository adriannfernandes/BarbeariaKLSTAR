package br.ufpb.barbeariaKlstar.entidades;

public class Corte extends Produto{

    private CategoriaCorte categoria;

    public Corte(String nome, Double preco, CategoriaCorte categoria) {
        super(nome, preco);
        this.categoria = categoria;

    }

    public CategoriaCorte getCategoriaCorte() {

        return this.categoria;

    }

}
