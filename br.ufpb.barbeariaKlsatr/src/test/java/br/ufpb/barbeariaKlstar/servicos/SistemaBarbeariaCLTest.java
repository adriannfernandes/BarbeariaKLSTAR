package br.ufpb.barbeariaKlstar.servicos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SistemaBarbeariaCLTest {

    SistemaBarbeariaCL sistema;

    @BeforeEach
    void setUp() {
        sistema = new SistemaBarbeariaCL();
    }

    @Test
    void testCadastrarFuncionario() {
        assertEquals(0, sistema.pesquisaFuncionarioPorNome("Samuel").size());
        assertTrue(sistema.cadastrarFuncionario("Samuel", "18/11/2000", "8399182", "samuel@email", "708534"));
        assertEquals(1 ,sistema.pesquisaFuncionarioPorNome("Samuel").size());
        assertFalse(sistema.cadastrarFuncionario("Samuel", "18/11/2000", "8399182", "samuel@email", "708534"));
        assertEquals(1, sistema.pesquisaFuncionarioPorNome("Samuel").size());
    }

    @Test
    void testPesquisaFuncionarioPorNome() {

        assertTrue(sistema.pesquisaFuncionarioPorNome("Samuel").size() == 0);
        sistema.cadastrarFuncionario("Samuel", "18/11/2000", "8399182", "samuel@email", "708534");
        assertTrue(sistema.pesquisaFuncionarioPorNome("Samuel").size() == 1);
        //assertTrue();

    }

    @Test
    void testCadastrarCliente() {
        assertEquals(0, sistema.pesquisarTodosClientes().size());
        assertTrue(sistema.cadastrarCliente("Chico", "083999", "chico@email"));
        assertEquals(1, sistema.pesquisarTodosClientes().size());
        assertFalse(sistema.cadastrarCliente("Chico", "083999", "chico@email"));
        assertTrue(sistema.cadastrarCliente("Adrian", "0837564", "adrian@email"));
        assertEquals(2, sistema.pesquisarTodosClientes().size());

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
