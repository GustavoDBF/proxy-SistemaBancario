package org.example;

import java.util.Arrays;
import java.util.List;

public class Conta implements IConta {

    private Integer numero;
    private String agencia;
    private String titular;
    private Float saldo;

    public Conta(int numero) {
        this.numero = numero;
        Conta objeto = BD.getConta(numero);
        this.agencia = objeto.agencia;
        this.titular = objeto.titular;
        this.saldo = objeto.saldo;
    }

    public Conta(Integer numero, String agencia, String titular, Float saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public List<String> obterDadosConta() {
        return Arrays.asList(this.agencia, this.titular);
    }

    @Override
    public Float obterSaldo(Usuario usuario) {
        return this.saldo;
    }
}