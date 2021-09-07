package tesky.mn2.derivative;

import tesky.mn2.function.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int derivativeMethod;
        Function function;
        int functionIndex;
        double x;

        Scanner in = new Scanner(System.in);


        System.out.println("Insira o valor de X:");
        x = in.nextDouble();


        System.out.println("Indique que função você deseja calcular.\n" +
                "0 - sen(x)\n" +
                "1 - (sen(2x) + 4x^2 + 3x)^2\n" +
                "2 - (cos(2x))^2\n" +
                "3 - 1/(cbrt(x^2))\n" +
                "4 - 1/(sqrt(4 - x^2))\n" +
                "5 - sqrt(e^3x + 4 * x^2)"
        );
        functionIndex = in.nextInt();

        switch (functionIndex) {
            case 0:
                function = new Sin();
                break;
            case 1:
                function = new Sin2();
                break;
            case 2:
                function = new Cos2();
                break;
            case 3:
                function = new Exponential1();
                break;
            case 4:
                function = new Exponential2();
                break;
            case 5:
                function = new Exponential3();
                break;
            default:
                throw new RuntimeException("Função inválida!");
        }

        System.out.println("Indique o método que deseja calcular.\n" +
                "0 - Série de Taylor\n" +
                "1 - Polinômio de Newton");
        derivativeMethod = in.nextInt();

        switch (derivativeMethod) {
            case 0:
                System.out.println(DerivativeMethods.taylorSeriesDerivativeSecond(function, x));
                break;
            case 1:
                System.out.println(DerivativeMethods.newtonPolynomialDerivativeSecond(function, x));
                break;
            default:
                System.err.println("Grau inválido!");
        }
    }
}
