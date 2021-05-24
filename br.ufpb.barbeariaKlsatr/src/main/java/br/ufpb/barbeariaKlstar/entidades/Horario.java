package br.ufpb.barbeariaKlstar.entidades;

import java.util.Date;

public class Horario {

    private String nomeDoCliente;
    private String telefoneDoCliente;
    private String horaAgendada;
    private Date data;

    public Horario(String nomeDoCliente, String telefoneDoCliente, String horaAgendada, Date data) {
        this.nomeDoCliente = nomeDoCliente;
        this.telefoneDoCliente = telefoneDoCliente;
        this.horaAgendada = horaAgendada;
        this.data = data;
    }

    public Horario() {
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getTelefoneDoCliente() {
        return telefoneDoCliente;
    }

    public void setTelefoneDoCliente(String telefoneDoCliente) {
        this.telefoneDoCliente = telefoneDoCliente;
    }

    public String getHoraAgendada() {
        return horaAgendada;
    }

    public void setHoraAgendada(String horaAgendada) {
        this.horaAgendada = horaAgendada;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
