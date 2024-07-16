package Aplicação;

import java.util.Locale;
import java.util.Scanner;

import Cliente.cadastroCliente;
import Cliente.dadosCliente;
import Conta.conta;
import Conta.contaCorrente;
import Conta.contaPoupanca;

public class Programa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        cadastroCliente cadastro = new cadastroCliente();

       
        dadosCliente novoCliente = cadastro.novoCliente();
        if (novoCliente != null) {
            cadastro.adicionarCliente(novoCliente);

            
            conta cc = new contaCorrente(novoCliente);
            conta cp = new contaPoupanca(novoCliente);

            
            try {
                
                cc.depositar(100);
                cc.tranferir(50, cp);

               
                cc.imprimirExtrato();
                cp.imprimirExtrato();

                
                System.out.println("\nDigite o CPF para buscar o cliente:");
                String cpfBusca = sc.nextLine();
                cadastro.buscarEExibirClientePorCpf(cpfBusca);
            } catch (Exception e) {
                System.out.println("Erro durante a execução das operações: " + e.getMessage());
            }
        } else {
            System.out.println("Não foi possível cadastrar o cliente.");
        }

        sc.close();
    }
}

