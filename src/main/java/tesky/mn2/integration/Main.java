package tesky.mn2.integration;

import tesky.mn2.function.Cos2;
import tesky.mn2.function.Function;
import tesky.mn2.function.Sin;
import tesky.mn2.function.Sin2;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        executeNewtonCotes();
        executeGaussLegendre();
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
}
