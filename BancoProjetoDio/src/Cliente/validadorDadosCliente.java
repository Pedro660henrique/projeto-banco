package Cliente;

import java.util.regex.Pattern;

public class validadorDadosCliente {

    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");

    public static boolean validarCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return false;
        }

        String cpfNumeros = cpf.replaceAll("\\D", "");

        return cpfNumeros.length() == 11 && validarCpfAlgoritmo(cpfNumeros);
    }

    private static boolean validarCpfAlgoritmo(String cpf) {
        int soma = 0;
        int peso = 10;

        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * peso--;
        }

        int resto = soma % 11;
        if (resto < 2) {
            if (cpf.charAt(9) != '0') return false;
        } else {
            if (cpf.charAt(9) != (11 - resto + '0')) return false;
        }

        soma = 0;
        peso = 11;

        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * peso--;
        }

        resto = soma % 11;
        if (resto < 2) {
            return cpf.charAt(10) == '0';
        } else {
            return cpf.charAt(10) == (11 - resto + '0');
        }
    }

    public static boolean validarCliente(dadosCliente cliente) {
        if (cliente == null) {
            return false;
        }

        String cpf = cliente.getCpf();
        boolean cpfValido = validarCpf(cpf);
        boolean nomeValido = cliente.getNome() != null && !cliente.getNome().trim().isEmpty();
        boolean dataNascimentoValida = cliente.getDataNascimento() != null && !cliente.getDataNascimento().trim().isEmpty();

        return cpfValido && nomeValido && dataNascimentoValida;
    }
}



