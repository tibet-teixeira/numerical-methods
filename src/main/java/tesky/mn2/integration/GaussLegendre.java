package tesky.mn2.integration;

import tesky.mn2.function.Function;

public class GaussLegendre implements IntegrationMethod {
    public static double gaussLegendre2Points(Function function, double a, double b) {
        double legendreRoot1 = -0.577350269;
        double legendreRoot2 = 0.577350269;

        double midpoint = (a + b) / 2;
        double h = (b - a) / 2;

        double p1 = midpoint + h * legendreRoot1;
        double p2 = midpoint + h * legendreRoot2;

        return (function.f(p1) + function.f(p2)) * h;
    }

    public static double gaussLegendre3Points(Function function, double a, double b) {
        double legendreRoot1 = -0.774596669;
        double legendreRoot2 = 0;
        double legendreRoot3 = 0.774596669;

        double w1 = 0.5555556;
        double w2 = 0.8888889;
        double w3 = 0.5555556;

        double midpoint = (a + b) / 2;
        double h = (b - a) / 2;

        double p1 = midpoint + h * legendreRoot1;
        double p2 = midpoint + h * legendreRoot2;
        double p3 = midpoint + h * legendreRoot3;

        return (w1 * function.f(p1) + w2 * function.f(p2) + w3 * function.f(p3)) * h;
    }

    public static double gaussLegendre4Points(Function function, double a, double b) {
        double legendreRoot1 = -0.861136312;
        double legendreRoot2 = -0.339981044;
        double legendreRoot3 = 0.339981044;
        double legendreRoot4 = 0.861136312;

        double w1 = 0.3478548;
        double w2 = 0.6521452;
        double w3 = 0.6521452;
        double w4 = 0.3478548;

        double midpoint = (a + b) / 2;
        double h = (b - a) / 2;

        double p1 = midpoint + h * legendreRoot1;
        double p2 = midpoint + h * legendreRoot2;
        double p3 = midpoint + h * legendreRoot3;
        double p4 = midpoint + h * legendreRoot4;

        return (w1 * function.f(p1) + w2 * function.f(p2) + w3 * function.f(p3) + w4 * function.f(p4)) * h;
    }

    public static double gaussLegendreTolerance2Points(Function function, double a, double b, double tolerance) {
        double current = 0.1;
        double anterior = 100;
        double sum;
        double delta;
        double x0;
        double x1;

        int N = 1;
        int iteration = 0;

        while (Math.abs((current - anterior) / current) > tolerance) {
            N *= 2;
            sum = 0;
            delta = (b - a) / N;
            iteration += 1;


            for (int i = 0; i < N; i++) {
                x0 = a + i * delta;
                x1 = x0 + delta;

                sum += gaussLegendre2Points(function, x0, x1);
            }

            anterior = current;
            current = sum;
        }

        System.out.println("Resultado foi obtido em " + iteration + " iterações");

        return current;
    }

    public static double gaussLegendreTolerance3Points(Function function, double a, double b, double tolerance) {
        double current = 0.1;
        double anterior = 100;
        double sum;
        double delta;
        double x0;
        double x1;

        int N = 1;
        int iteration = 0;

        while (Math.abs((current - anterior) / current) > tolerance) {
            N *= 2;
            sum = 0;
            delta = (b - a) / N;
            iteration += 1;

            for (int i = 0; i < N; i++) {
                x0 = a + i * delta;
                x1 = x0 + delta;

                sum += gaussLegendre3Points(function, x0, x1);
            }

            anterior = current;
            current = sum;
        }

        System.out.println("Resultado foi obtido em " + iteration + " iterações");

        return current;
    }

    public static double gaussLegendreTolerance4Points(Function function, double a, double b, double tolerance) {
        double current = 0.1;
        double anterior = 100;
        double sum;
        double delta;
        double x0;
        double x1;

        int N = 1;
        int iteration = 0;

        while (Math.abs((current - anterior) / current) > tolerance) {
            N *= 2;
            sum = 0;
            delta = (b - a) / N;
            iteration += 1;

            for (int i = 0; i < N; i++) {
                x0 = a + i * delta;
                x1 = x0 + delta;

                sum += gaussLegendre4Points(function, x0, x1);
            }

            anterior = current;
            current = sum;
        }

        System.out.println("Resultado foi obtido em " + iteration + " iterações");

        return current;
    }
}
