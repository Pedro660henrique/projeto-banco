package Conta;

import Cliente.dadosCliente;

public class contaCorrente extends conta{

	public contaCorrente(dadosCliente cliente) {
		super(cliente);
	}

	@Override
    public void imprimirExtrato() {
        System.out.println("==== Extrato Conta Corrente ====");
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

