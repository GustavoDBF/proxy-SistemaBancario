package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ContaProxyTest {

    @BeforeEach
    void setUp() {
        BD.addConta(new Conta(1001, "0001-X", "Carlos Silva", 2500.50f));
        BD.addConta(new Conta(1002, "0002-Y", "Marta Souza", 14500.00f));
    }

    @Test
    void deveRetornarDadosBasicosDaConta() {
        ContaProxy conta = new ContaProxy(1001);

        assertEquals(Arrays.asList("0001-X", "Carlos Silva"), conta.obterDadosConta());
    }

    @Test
    void deveRetonarSaldoDaContaParaGerente() {
        Usuario usuario = new Usuario("Roberto", true);
        ContaProxy conta = new ContaProxy(1002);

        assertEquals(14500.00f, conta.obterSaldo(usuario));
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoAutorizadoAoConsultarSaldo() {
        try {
            Usuario usuario = new Usuario("Lucas", false);
            ContaProxy conta = new ContaProxy(1002);

            conta.obterSaldo(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Usuário não autorizado", e.getMessage());
        }
    }
}