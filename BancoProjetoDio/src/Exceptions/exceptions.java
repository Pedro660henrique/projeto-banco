package Exceptions;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import Cliente.dadosCliente;

public class exceptions {

    public static void tratarEntradaCliente() {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        try {
            System.out.println("Digite o seu nome: ");
            dadosCliente cliente = new dadosCliente();
            cliente.setNome(sc.nextLine());

            System.out.println("Digite a sua Data de nascimento (dd/mm/aaaa): ");
            cliente.setDataNascimento(sc.nextLine());

            System.out.println("Digite o seu CPF: ");
            cliente.setCpf(sc.nextLine());

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, digite um valor válido.");
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}



