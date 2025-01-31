package Conta;

public interface iConta {

    void sacar(double valor);

    void depositar(double valor);

    void tranferir(double valor, conta contaDestino);

    void imprimirExtrato();

    void operacaoDesejada(int opcao);

    void novoCliente();

    void contaDesejada();
}

