package Conta;

import java.util.Locale;
import java.util.Scanner;
import Cliente.dadosCliente;

public abstract class conta implements iConta {
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia, numero;
    protected double saldo;
    protected dadosCliente cliente;

    public conta(dadosCliente cliente) {
        this.agencia = conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    @Override
    public void tranferir(double valor, conta contaDestino) {
        if (valor > 0 && valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public void operacaoDesejada(int opcao) {
        double valor;
        switch (opcao) {
            case 1:
                System.out.println("Digite o valor que deseja sacar: ");
                valor = sc.nextDouble();
                sacar(valor);
                break;
            case 2:
                System.out.println("Digite o valor que deseja depositar: ");
                valor = sc.nextDouble();
                depositar(valor);
                break;
            case 3:
                System.out.println("Digite o valor que deseja transferir: ");
                valor = sc.nextDouble();
                break;
            default:
                System.out.println("Opção indisponível.");
                break;
        }
    }

    @Override
    public void contaDesejada() {

    }

    @Override
    public void novoCliente() {

    }

    public void escolherContaDesejada(int tipoConta) {
        System.out.println("Escolha a conta que deseja acessar: ");
        int tipo = sc.nextInt();
        conta conta = null;
        switch (tipo) {
            case 1:
                conta = new contaCorrente(cliente);
                break;
            case 2:
                conta = new contaPoupanca(cliente);
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }
        System.out.println("Digite a operação que deseja fazer: ");
        int operacao = sc.nextInt();
        conta.operacaoDesejada(operacao);
        sc.close();
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}

