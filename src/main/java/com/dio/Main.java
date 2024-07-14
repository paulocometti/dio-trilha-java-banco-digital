package com.dio;

import com.dio.domain.Cliente;
import com.dio.domain.Conta;
import com.dio.domain.ContaCorrente;
import com.dio.domain.ContaPoupanca;
import com.dio.exceptions.SaldoException;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Paulo");

        Conta contaCorrente = new ContaCorrente(cliente);
        Conta contaPoupanca = new ContaPoupanca(cliente);

        contaCorrente.depositar(200.00);

        try {
            contaPoupanca.sacar(100.50);
        } catch (SaldoException e) {
            System.out.println("Sem saldo suficiente");
        }

        try {
            contaCorrente.transferir(150.00, contaPoupanca);
        } catch (SaldoException e) {
            System.out.println("Sem saldo suficiente");
        }

        contaCorrente.ìmprimirExtrato();
        contaPoupanca.ìmprimirExtrato();
    }
}