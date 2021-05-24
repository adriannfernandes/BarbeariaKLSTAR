package br.ufpb.barbeariaKlstar.servicos;

import br.ufpb.barbeariaKlstar.entidades.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JTable;

public class SistemaBarbeariaGUI extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLabel linha1, linha2;
    SistemaBarbearia agenda = new SistemaBarbeariaCL();
    JMenuBar barraDeMenu = new JMenuBar();
    private JTable table;
    private final String colunas[] = { "Dia", "Status" };
    private final String dados[][] = { { "Segunda-feira", "Disponível" }, { "Terça-feira", "Disponível" },
            { "Quarta-feira", "Indisponível" }, { "Quinta-feira", "Indisponível" }, { "Sexta-feira", "Disponível" },
            { "Sábado", "Disponóvel" }};

    public SistemaBarbeariaGUI() {
        setTitle("Sistema Barbearia");
        setSize(600, 400); // tamanho da janela
        setLocation(150, 150);
        setResizable(true);
        setBackground(Color.white);
        linha1 = new JLabel("Barber Shop", JLabel.CENTER);
        linha1.setForeground(Color.black);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(new JLabel());

        // área cliente;
        JMenu menuCliente = new JMenu("Cliente");
        JMenuItem menuCadastrarCliente = new JMenuItem("Cadastrar Cliente");
        JMenuItem menuPesquisarCliente = new JMenuItem("Pesquisar Cliente");
        JMenuItem menuRemoverCliente = new JMenuItem("Remover Cliente");
        menuCliente.add(menuCadastrarCliente);
        menuCliente.add(menuPesquisarCliente);
        menuCliente.add(menuRemoverCliente);

        // área funcionario;

        JMenu menuFuncionario = new JMenu("Funcionário");
        JMenuItem menuCadastrarFuncionario = new JMenuItem("Cadastrar Funcionário");
        JMenuItem menuPesquisarFuncionario = new JMenuItem("Pesquisar Funcionário");
        JMenuItem menuRemoverFuncionario = new JMenuItem("Remover Funcionário");
        menuFuncionario.add(menuCadastrarFuncionario);
        menuFuncionario.add(menuPesquisarFuncionario);
        menuFuncionario.add(menuRemoverFuncionario);

        // área horario;
        JMenu menuHorario = new JMenu("Horários");
        JMenuItem menuListarHorarios = new JMenuItem("Listar Horários");
        menuHorario.add(menuListarHorarios);

        // menuPesquisarCliente.addActionListener(new AgendaSearchController(agenda,
        // this));
        menuPesquisarCliente.addActionListener((ae) -> {
            String telefone = JOptionPane.showInputDialog(this, "Qual o telefone para pesquisa?");

            Cliente contatosEnc = agenda.pesquisarCliente(telefone);

            if (contatosEnc != null) {
                JOptionPane.showMessageDialog(this, "Cliente encontrado:" + contatosEnc.toString());

            } else {
                JOptionPane.showMessageDialog(this, "Não foi encontrado nenhum cliente!");
            }
        });



        menuCadastrarCliente.addActionListener((ae) -> {
            String nome = JOptionPane.showInputDialog(this, "Qual o nome do cliente?");
            String telefone = JOptionPane.showInputDialog(this, "Qual o telefone do cliente?");
            String email = JOptionPane.showInputDialog(this, "Qual o email do cliente?");
            boolean cadastrou = agenda.cadastrarCliente(nome, telefone, email);
            if (cadastrou) {
                JOptionPane.showMessageDialog(this, "Cliente cadastrado");
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não foi cadastrado. " + "Verifique se já não existia");
            }
        });

        menuCadastrarFuncionario.addActionListener((ae) -> {
            String nome = JOptionPane.showInputDialog(this, "Qual o nome do funcionário?");
            String dataNascimento = JOptionPane.showInputDialog(this, "Qual é a data de nascimento do funcionário?");
            String telefone = JOptionPane.showInputDialog(this, "Qual o telefone do funcionário?");
            String email = JOptionPane.showInputDialog(this, "Qual o email do cliente?");
            String cpf = JOptionPane.showInputDialog(this, "Qual é o CPF do funcionário?");
            boolean cadastrou = agenda.cadastrarFuncionario(nome, dataNascimento, telefone, email, cpf);
            if (cadastrou) {
                JOptionPane.showMessageDialog(this, "Funcionário cadastrado");
            } else {
                JOptionPane.showMessageDialog(this, "Funcionário não foi cadastrado. " + "Verifique se já não existia");
            }
        });

        menuPesquisarFuncionario.addActionListener((ae) -> {

            String nome = JOptionPane.showInputDialog(this, "Qual o nome do funcionário?");
            Collection<Funcionario> funcAcha = agenda.pesquisaFuncionarioPorNome(nome);
            for (int i = 0; i < funcAcha.size(); i++) {
                JOptionPane.showMessageDialog(this, "Funcionário(s) encontrado(s): " + funcAcha);
            }

        });

        menuListarHorarios.addActionListener((ae) -> {

            table = new JTable(dados, colunas);
            table.setPreferredScrollableViewportSize(new Dimension(0,0));
            table.setFillsViewportHeight(true);

            JScrollPane scrollPane = new JScrollPane(table);

            add(scrollPane);
        });

        barraDeMenu.add(menuCliente);
        barraDeMenu.add(menuFuncionario);
        barraDeMenu.add(menuHorario);
        setJMenuBar(barraDeMenu);
    }

    // ...
    public static void main(String[] args) {
        JFrame janela = new SistemaBarbeariaGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}