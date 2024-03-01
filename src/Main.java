import java.util.Scanner;

/**
 * IMPLEMENTAR UMA CALCULADORA COM AS SEGUINTES OPERAÇÕES
 * SOMAR
 * SUBTRAIR
 * MULTIPLICAR
 * DIVIDIR
 */
public class Main {
    public static void main(String[] args) {
        // Declaração da calculadora que será utilizada para realizar as operações
        Calculadora calculadora = new Calculadora();
        // Declaração do scanner que será utilizado para armazenar os valores digitados pelo usuário
        Scanner scanner = new Scanner(System.in);

        // Variáveis responsáveis por armazenar valores digitados pelo usuário e o resultado da operação
        double valor1, valor2, resultado = 0;
        // Variável responsável por armazenar a operação que o usuário deseja utilizar
        int operacao;
        // Variável responsável por exibir a operação selecionada
        String operacaoOutput = "";
        // Variável responsável por armazenar exception ocorrida na execução do método de divisão
        Exception error = null;

        System.out.print("Informe o primeiro valor: ");
        valor1 = scanner.nextDouble();
        System.out.print("Informe o segundo valor: ");
        valor2 = scanner.nextDouble();

        do {
            System.out.println("Informe a operação desejada: ");
            System.out.println("(1) SOMAR\n(2) SUBTRAIR\n(3) MULTIPLICAR\n(4) DIVIDIR");
            operacao = scanner.nextInt();
        }
        while (operacao < 1 || operacao > 4);

        operacaoOutput = switch (operacao) {
            case 1 -> {
                resultado = calculadora.somar(valor1, valor2);
                yield "SOMAR";
            }
            case 2 -> {
                resultado = calculadora.subtrair(valor1, valor2);
                yield "SUBTRAIR";
            }
            case 3 -> {
                resultado = calculadora.multiplicar(valor1, valor2);
                yield "MULTIPLICAR";
            }
            case 4 -> {
                try {
                    resultado = calculadora.dividir(valor1, valor2);
                } catch (Exception e) {
                    error = e;
                }
                yield "DIVIDIR";
            }
            default -> operacaoOutput;
        };
        if(error != null) {
            System.out.println(error.getMessage());
        }else {
            printResultado(operacaoOutput, resultado);

        }
    }

    private static void printResultado(String operacao, Double resultado) {
        System.out.println("A operação " + operacao + " teve resultado: " + resultado);
    }
}