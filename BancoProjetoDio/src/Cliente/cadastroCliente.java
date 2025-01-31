package Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class cadastroCliente {
    List<dadosCliente> clientes;
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    public cadastroCliente() {
        this.clientes = new ArrayList<>();
    }

    public dadosCliente novoCliente() {
        System.out.println("Digite o seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite a sua Data de nascimento (dd/mm/aaaa): ");
        String dataNascimento = sc.nextLine();

        System.out.println("Digite o seu CPF: ");
        String cpf = sc.nextLine();

        dadosCliente novoCliente = new dadosCliente();
        novoCliente.setNome(nome);
        novoCliente.setDataNascimento(dataNascimento);
        novoCliente.setCpf(cpf);

        if (validadorDadosCliente.validarCliente(novoCliente)) {
            return novoCliente;
        } else {
            System.out.println("Cliente inválido. Por favor, verifique os dados.");
            return null;
        }
    }

    public void adicionarCliente(dadosCliente cliente) {
        clientes.add(cliente);
    }

    public dadosCliente buscarClientePorCpf(String cpf) {
        for (dadosCliente cliente : clientes) {
            if (cliente.getCpf() != null && cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void buscarEExibirClientePorCpf(String cpf) {
        dadosCliente clienteEncontrado = buscarClientePorCpf(cpf);

        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("Nome: " + clienteEncontrado.getNome());
            System.out.println("CPF: " + clienteEncontrado.getCpf());
            System.out.println("Data de Nascimento: " + clienteEncontrado.getDataNascimento());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public List<dadosCliente> getClientes() {
        return clientes;
    }
}
	        
