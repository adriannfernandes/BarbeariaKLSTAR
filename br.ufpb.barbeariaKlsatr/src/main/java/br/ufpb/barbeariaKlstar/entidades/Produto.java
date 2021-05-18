package br.ufpb.barbeariaKlstar.entidades;

public class Produto {

    private String name;
    private String price;

    public Produto(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public Produto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
