package br.ufpb.barbeariaKlstar.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SistemaBarbeariaCLTest {

    SistemaBarbeariaCL sistema;

    @BeforeEach
    void setUp() {
        sistema = new SistemaBarbeariaCL();
    }

    @Test
    void testCadastrarFuncionario() {
        /*assertEquals(0, sistema.pesquisaFuncionarioPorNome("Samuel").size());
        assertTrue(sistema.cadastrarFuncionario("Samuel", "18/11/2000", "8399182", "samuel@email", "708534"));
        assertEquals(1 ,sistema.pesquisaFuncionarioPorNome("Samuel").size());
        assertFalse(sistema.cadastrarFuncionario("Samuel", "18/11/2000", "8399182", "samuel@email", "708534"));
        assertEquals(1, sistema.pesquisaFuncionarioPorNome("Samuel").size());*/

        assertTrue(sistema.cadastrarFuncionario("Maria", "18/11/2000", "83991843567", "maria@email", "707"));
        assertFalse(sistema.cadastrarFuncionario("123", "18/11/2000", "83991843567", "maria@email", "707"));
        assertFalse(sistema.cadastrarFuncionario("João", "18/11/2000", "wasd", "joao@email", "708"));
        assertFalse(sistema.cadastrarFuncionario("Pedro", "18/11/2000", "083991743655", "pedro@email", "qwe"));

    }

    @Test
    void testPesquisaFuncionarioPorNome() {
        assertEquals(0, sistema.pesquisarProdutosPeloNome("Carlos").size());
        sistema.cadastrarFuncionario("Maria", "18/11/2000", "83991843567", "maria@email", "707");
        sistema.cadastrarFuncionario("Pedro", "18/11/2000", "083991743655", "pedro@email", "708");
        assertEquals(1, sistema.pesquisaFuncionarioPorNome("maria").size());

    }


    @Test
    void testPesquisaFuncionarioPorCpf() {

        /*assertTrue(sistema.pesquisaFuncionarioPorNome("Samuel").size() == 0);
        sistema.cadastrarFuncionario("Samuel", "18/11/2000", "8399182", "samuel@email", "708534");
        assertTrue(sistema.pesquisaFuncionarioPorNome("Samuel").size() == 1);
        */

        //Metodo ainda será implementado

        assertThrows(FuncionarioNaoExisteException.class, ()-> sistema.pesquisaFuncionarioPorCpf("032"));

        sistema.cadastrarFuncionario("João", "18/11/2000", "83991843567", "joao@email", "032");
        sistema.cadastrarFuncionario("Pedro", "18/11/2000", "083991743655", "pedro@email", "033");

        try {
            assertEquals(1, sistema.PesquisaFuncionarioPorCpf("032"));
        } catch (FuncionarioNaoExisteException e) {
            fail("Deveria retornar um funcionario com esse cpf");
        }



    }

    @Test
    void testCadastrarCliente() {
        assertTrue(sistema.cadastrarCliente("Maria", "83991843567", "maria@email"));
        assertFalse(sistema.cadastrarCliente("123", "83991843567", "marial@email"));
        assertFalse(sistema.cadastrarCliente("Sergio", "wasd", "sergio@email"));

    }

    @Test
    void testPesquisaClientePorTelefone() {
        assertThrows(ClienteNaoExisteException.class, ()-> sistema.pesquisaClientePorTelefone("083993743577"));

        sistema.cadastrarCliente("Samuel", "083993521644", "samuel@email");
        sistema.cadastrarCliente("Francisco", "081991743566", "francisco@email");

        try {
            assertEquals(1, sistema.pesquisarCliente("081991743566"));
        } catch (ClienteNaoExisteException e) {
            fail("Deveria retornar um cliente com esse telefone");
        }
    }

    @Test
    void testPesquisarTodosClientes() {
        //TODO
    }

    void testCadastrarProduto() {
        //assertEquals(0, sistema.pesquisarProdutosPeloCodigo().size());
        //assertTrue(sistema.cadastraProduto("Cerveja", 4.5, "123", ));
        //TODO
    }

}
