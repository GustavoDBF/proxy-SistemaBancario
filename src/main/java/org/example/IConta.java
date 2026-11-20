package org.example;

import java.util.List;

public interface IConta {
    List<String> obterDadosConta();
    Float obterSaldo(Usuario usuario);
}