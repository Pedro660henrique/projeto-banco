package Conta;

import Cliente.dadosCliente;

public class contaPoupanca extends conta {

    public contaPoupanca(dadosCliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("==== Extrato Conta Poupança ====");
        super.imprimirInfosComuns();
    }

    @Override
    public void operacaoDesejada(int opcao) {
       
    }

    @Override
    public void novoCliente() {
       
    }

    @Override
    public void contaDesejada() {
       
    }
}
