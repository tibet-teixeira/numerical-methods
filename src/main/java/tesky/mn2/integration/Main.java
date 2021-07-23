package tesky.mn2.integration;

import tesky.mn2.function.*;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        executeNewtonCotes();
//        executeGaussLegendre();
//        executeGaussHermite();
//        executeGaussLaguerre();
//        executeGaussChebyshev();
        executeExercise07();
    }

    private static void executeNewtonCotes() {
        double a;
        double b;
        int N;
        String integrationPhilosophy;
        Function function;
        int functionIndex;
        double tolerance = Math.pow(10, -6);

        Scanner in = new Scanner(System.in);

        System.out.println("Insira o valor de A:");
        a = in.nextDouble();

        System.out.println("Insira o valor de B:");
        b = in.nextDouble();


        while (a > b) {
            System.err.println("o valor de A não pode ser maior que B.");

            System.out.println("Insira novamente o valor de A:");
            a = in.nextDouble();

            System.out.println("Insira novamente o valor de B:");
            b = in.nextDouble();
        }

        System.out.println("Indique que função você deseja calcular.\n" +
                "0 - sen(x)\n" +
                "1 - (sen(2x) + 4x^2 + 3x)^2\n" +
                "2 - (cos(2x))^2");
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
            default:
                throw new RuntimeException("Função inválida!");
        }

        System.out.println("Insira o grau do polinômio (1 a 4):");
        N = in.nextInt();

        System.out.println("Insira a filosofia de integração (aberta ou fechada):");
        integrationPhilosophy = in.next();

        if (IntegrationPhilosophy.isOpened(integrationPhilosophy.toLowerCase(Locale.ROOT))) {
            System.out.println("Aberto");
            switch (N) {
                case 1:
                    System.out.println(NewtonCotes.openedToleranceNewtonCotesDegree1(function, a, b, tolerance));
                    break;
                case 2:
                    System.out.println(NewtonCotes.openedToleranceNewtonCotesDegree2(function, a, b, tolerance));
                    break;
                case 3:
                    System.out.println(NewtonCotes.openedToleranceNewtonCotesDegree3(function, a, b, tolerance));
                    break;
                case 4:
                    System.out.println(NewtonCotes.openedToleranceNewtonCotesDegree4(function, a, b, tolerance));
                    break;
                default:
                    throw new RuntimeException("Grau inválido!");
            }
        } else if (IntegrationPhilosophy.isClosed(integrationPhilosophy.toLowerCase(Locale.ROOT))) {
            System.out.println("Fechado");
            switch (N) {
                case 1:
                    System.out.println(NewtonCotes.closedToleranceNewtonCotesDegree1(function, a, b, tolerance));
                    break;
                case 2:
                    System.out.println(NewtonCotes.closedToleranceNewtonCotesDegree2(function, a, b, tolerance));
                    break;
                case 3:
                    System.out.println(NewtonCotes.closedToleranceNewtonCotesDegree3(function, a, b, tolerance));
                    break;
                case 4:
                    System.out.println(NewtonCotes.closedToleranceNewtonCotesDegree4(function, a, b, tolerance));
                    break;
                default:
                    System.err.println("Grau inválido!");
            }
        } else {
            throw new RuntimeException("Filosofia de integração desconhecida.");
        }
    }


    private static void executeGaussLegendre() {
        double a;
        double b;
        int N;
        Function function;
        int functionIndex;
        double tolerance = Math.pow(10, -6);

        Scanner in = new Scanner(System.in);

        System.out.println("Insira o valor de A:");
        a = in.nextDouble();

        System.out.println("Insira o valor de B:");
        b = in.nextDouble();


        while (a > b) {
            System.err.println("o valor de A não pode ser maior que B.");

            System.out.println("Insira novamente o valor de A:");
            a = in.nextDouble();

            System.out.println("Insira novamente o valor de B:");
            b = in.nextDouble();
        }

        System.out.println("Indique que função você deseja calcular.\n" +
                "0 - sen(x)\n" +
                "1 - (sen(2x) + 4x^2 + 3x)^2\n" +
                "2 - (cos(2x))^2");
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
            default:
                throw new RuntimeException("Função inválida!");
        }

        System.out.println("Insira a quantidade de pontos (2 a 4):");
        N = in.nextInt();

        switch (N) {
            case 2:
                System.out.println(GaussLegendre.gaussLegendreTolerance2Points(function, a, b, tolerance));
                break;
            case 3:
                System.out.println(GaussLegendre.gaussLegendreTolerance3Points(function, a, b, tolerance));
                break;
            case 4:
                System.out.println(GaussLegendre.gaussLegendreTolerance4Points(function, a, b, tolerance));
                break;
            default:
                System.err.println("Grau inválido!");
        }
    }

    private static void executeGaussHermite() {
        int N;
        Function function;
        int functionIndex;

        Scanner in = new Scanner(System.in);

        System.out.println("Indique que função você deseja calcular.\n" +
                "0 - sen(x)\n" +
                "1 - (sen(2x) + 4x^2 + 3x)^2\n" +
                "2 - (cos(2x))^2\n" +
                "3 - 1/(cbrt(x^2))\n" +
                "4 - 1/(sqrt(4 - x^2))");
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
            default:
                throw new RuntimeException("Função inválida!");
        }

        System.out.println("Insira a quantidade de pontos (2 a 4):");
        N = in.nextInt();

        switch (N) {
            case 2:
                System.out.println(GaussHermite.gaussHermite2Points(function));
                break;
            case 3:
                System.out.println(GaussHermite.gaussHermite3Points(function));
                break;
            case 4:
                System.out.println(GaussHermite.gaussHermite4Points(function));
                break;
            default:
                System.err.println("Grau inválido!");
        }
    }

    private static void executeGaussLaguerre() {
        int N;
        Function function;
        int functionIndex;

        Scanner in = new Scanner(System.in);

        System.out.println("Indique que função você deseja calcular.\n" +
                "0 - sen(x)\n" +
                "1 - (sen(2x) + 4x^2 + 3x)^2\n" +
                "2 - (cos(2x))^2\n" +
                "3 - 1/(cbrt(x^2))\n" +
                "4 - 1/(sqrt(4 - x^2))");
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
            default:
                throw new RuntimeException("Função inválida!");
        }

        System.out.println("Insira a quantidade de pontos (2 a 4):");
        N = in.nextInt();

        switch (N) {
            case 2:
                System.out.println(GaussLaguerre.gaussLaguerre2Points(function));
                break;
            case 3:
                System.out.println(GaussLaguerre.gaussLaguerre3Points(function));
                break;
            case 4:
                System.out.println(GaussLaguerre.gaussLaguerre4Points(function));
                break;
            default:
                System.err.println("Grau inválido!");
        }
    }

    private static void executeGaussChebyshev() {
        int N;
        Function function;
        int functionIndex;

        Scanner in = new Scanner(System.in);

        System.out.println("Indique que função você deseja calcular.\n" +
                "0 - sen(x)\n" +
                "1 - (sen(2x) + 4x^2 + 3x)^2\n" +
                "2 - (cos(2x))^2\n" +
                "3 - 1/(cbrt(x^2))\n" +
                "4 - 1/(sqrt(4 - x^2))");
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
            default:
                throw new RuntimeException("Função inválida!");
        }

        System.out.println("Insira a quantidade de pontos que deseja calcular: ");
        N = in.nextInt();
        if (N < 1) throw new RuntimeException("A quantidade de pontos deve ser positiva");

        System.out.println(GaussChebyshev.gaussChebyshevNPoints(function, N));
    }

    private static void executeExercise07() {
        int exponential;
        Function function;
        int functionIndex;
        double a, b;

        double tolerance = Math.pow(10, -4);

        Scanner in = new Scanner(System.in);

        System.out.println("Insira o valor de A:");
        a = in.nextDouble();

        System.out.println("Insira o valor de B:");
        b = in.nextDouble();


        while (a > b) {
            System.err.println("o valor de A não pode ser maior que B.");

            System.out.println("Insira novamente o valor de A:");
            a = in.nextDouble();

            System.out.println("Insira novamente o valor de B:");
            b = in.nextDouble();
        }

        System.out.println("Indique que função você deseja calcular.\n" +
                "0 - sen(x)\n" +
                "1 - (sen(2x) + 4x^2 + 3x)^2\n" +
                "2 - (cos(2x))^2\n" +
                "3 - 1/(cbrt(x^2))\n" +
                "4 - 1/(sqrt(4 - x^2))");
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
            default:
                throw new RuntimeException("Função inválida!");
        }

        System.out.println("Indique o método que deseja calcular.\n" +
                "0 - Exponencial Simples\n" +
                "1 - Exponencial Composta");
        exponential = in.nextInt();

        switch (exponential) {
            case 0:
                calculateSimpleExponential(function, a, b, tolerance);
                break;
            case 1:
                calculatecCompoundExponential(function, a, b, tolerance);
                break;
            default:
                System.err.println("Grau inválido!");
        }
    }

    private static void calculateSimpleExponential(Function function, double a, double b, double tolerance) {
        double toleranceLocal = Math.pow(10, -3);
        double c = 1;
        Function simpleExponential = new SimpleExponential(function, a, b);
        double prev = 200;
        double current = 100;
        int iterations = 0;

        while (Math.abs((current - prev) / current) > tolerance) {
            prev = current;
            current = GaussLegendre.gaussLegendreTolerance4Points(simpleExponential, -c, c, toleranceLocal);
            c += 1;
            iterations += 1;
        }

        System.out.println(current + " " + iterations);
    }

    private static void calculatecCompoundExponential(Function function, double a, double b, double tolerance) {
        double toleranceLocal = Math.pow(10, -3);
        double c = 1;
        Function compoundExponential = new CompoundExponential(function, a, b);
        double prev = 200;
        double current = 100;
        int iterations = 0;

        while (Math.abs((current - prev) / current) > tolerance) {
            prev = current;
            current = GaussLegendre.gaussLegendreTolerance4Points(compoundExponential, -c, c, toleranceLocal);
            c += 1;
            iterations += 1;
        }

        System.out.println(current + " " + iterations + " " + c);
    }


}
