public class Calculadora {

    /**
     * Construtor da classe
     */
    public Calculadora(){}

    public double somar(double valorA, double valorB) {
        return valorA + valorB;
    }

    public double subtrair(double valorA, double valorB) {
        return valorA - valorB;
    }

    public double multiplicar(double valorA, double valorB) {
        return valorA * valorB;
    }

    public double dividir(double dividendo, double divisor) throws Exception {
        if(divisor == 0) {
            throw new Exception("Não é possível dividir por 0!");
        }
        return dividendo / divisor;
    }


}
