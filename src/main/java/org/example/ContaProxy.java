package org.example;

import java.util.List;

public class ContaProxy implements IConta {

    private Conta conta;
    private Integer numero;

    public ContaProxy(Integer numero) {
        this.numero = numero;
    }

    @Override
    public List<String> obterDadosConta() {
        if (this.conta == null) {
            this.conta = new Conta(this.numero);
        }
        return this.conta.obterDadosConta();
    }

    @Override
    public Float obterSaldo(Usuario usuario) {
        if (!usuario.isGerente()) {
            throw new IllegalArgumentException("Usuário não autorizado");
        }
        if (this.conta == null) {
            this.conta = new Conta(this.numero);
        }
        return this.conta.obterSaldo(usuario);
    }
}