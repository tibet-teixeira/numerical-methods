package tesky.mn2.integration;

import tesky.mn2.function.Function;

public class NewtonCotes implements IntegrationMethod {
    public static double basicOpenedNewtonCotesDegree1(Function function, double a, double b, double h) {
        return h * (function.f(a + (b - a) / 3) + function.f(a + (b - a) * 2 / 3)) / 2;
    }

    public static double basicOpenedNewtonCotesDegree2(Function function, double a, double b, double h) {
        return h * (2 * function.f(a + (b - a) / 4) + -1 * function.f(a + (b - a) / 2) + 2 * function.f(a + (b - a) * 3 / 4)) / 3;
    }

    public static double basicOpenedNewtonCotesDegree3(Function function, double a, double b, double h) {
        return h * (11 * function.f(a + (b - a) / 5) + function.f(a + (b - a) * 2 / 5) + function.f(a + (b - a) * 3 / 5) + 11 * function.f(a + (b - a) * 4 / 5)) / 24;
    }

    public static double basicOpenedNewtonCotesDegree4(Function function, double a, double b, double h) {
        return h * (11 * function.f(a + (b - a) / 6) + -14 * function.f(a + (b - a) / 3) + 26 * function.f(a + (b - a) / 2) + -14 * function.f(a + (b - a) * 2 / 3) + 11 * function.f(a + (b - a) * 5 / 6)) / 20;
    }

    public static double basicClosedNewtonCotesDegree1(Function function, double a, double b) {
        return (b - a) * (function.f(a) + function.f(b)) / 2;
    }

    public static double basicClosedNewtonCotesDegree2(Function function, double a, double b) {
        return (b - a) * (function.f(a) + 4 * function.f((a + b) / 2) + function.f(b)) / 6;
    }

    public static double basicClosedNewtonCotesDegree3(Function function, double a, double b) {
        return (b - a) * (function.f(a) + 3 * function.f(a + (b - a) / 3) + 3 * function.f(a + (b - a) * 2 / 3) + function.f(b)) * 3 / 24;
    }

    public static double basicClosedNewtonCotesDegree4(Function function, double a, double b) {
        return (b - a) * (7 * function.f(a) + 32 * function.f(a + (b - a) / 4) + 12 * function.f(a + (b - a) / 2) + 32 * function.f(a + (b - a) * 3 / 4) + 7 * function.f(b)) / 90;
    }

    public static double openedToleranceNewtonCotesDegree1(Function function, double a, double b, double tolerance) {
        double current, prev, sum, delta, x0, x1;

        current = 0.1;
        prev = 100;

        int N = 1;

        while (Math.abs((current - prev) / current) > tolerance) {
            N *= 2;
            sum = 0;
            delta = (b - a) / N;

            for (int i = 0; i < N; i++) {
                x0 = a + i * delta;
                x1 = x0 + delta;

                sum += basicOpenedNewtonCotesDegree1(function, x0, x1, delta);
            }

            prev = current;
            current = sum;
        }

        return current;
    }

    public static double openedToleranceNewtonCotesDegree2(Function function, double a, double b, double tolerance) {
        double current, prev, sum, delta, x0, x1;

        current = 0.1;
        prev = 100;

        int N = 1;

        while (Math.abs((current - prev) / current) > tolerance) {
            N *= 2;
            sum = 0;
            delta = (b - a) / N;

            for (int i = 0; i < N; i++) {
                x0 = a + i * delta;
                x1 = x0 + delta;

                sum += basicOpenedNewtonCotesDegree2(function, x0, x1, delta);
            }

            prev = current;
            current = sum;
        }

        return current;
    }

    public static double openedToleranceNewtonCotesDegree3(Function function, double a, double b, double tolerance) {
        double current, prev, sum, delta, x0, x1;

        current = 0.1;
        prev = 100;

        int N = 1;

        while (Math.abs((current - prev) / current) > tolerance) {
            N *= 2;
            sum = 0;
            delta = (b - a) / N;

            for (int i = 0; i < N; i++) {
                x0 = a + i * delta;
                x1 = x0 + delta;

                sum += basicOpenedNewtonCotesDegree3(function, x0, x1, delta);
            }

            prev = current;
            current = sum;
        }

        return current;
    }

    public static double openedToleranceNewtonCotesDegree4(Function function, double a, double b, double tolerance) {
        double current, prev, sum, delta, x0, x1;

        current = 0.1;
        prev = 100;

        int N = 1;

        while (Math.abs((current - prev) / current) > tolerance) {
            N *= 2;
            sum = 0;
            delta = (b - a) / N;

            for (int i = 0; i < N; i++) {
                x0 = a + i * delta;
                x1 = x0 + delta;

                sum += basicOpenedNewtonCotesDegree4(function, x0, x1, delta);
            }

            prev = current;
            current = sum;
        }

        return current;
    }

    public static double closedToleranceNewtonCotesDegree1(Function function, double a, double b, double tolerance) {
        double current, prev, sum, delta, x0, x1;

        current = 0.1;
        prev = 100;

        int N = 1;

        while (Math.abs((current - prev) / current) > tolerance) {
            N *= 2;
            sum = 0;
            delta = (b - a) / N;

            for (int i = 0; i < N; i++) {
                x0 = a + i * delta;
                x1 = x0 + delta;

                sum += basicClosedNewtonCotesDegree1(function, x0, x1);
            }

            prev = current;
            current = sum;
        }

        return current;
    }

    public static double closedToleranceNewtonCotesDegree2(Function function, double a, double b, double tolerance) {
        double current, prev, sum, delta, x0, x1;

        current = 0.1;
        prev = 100;

        // Initial number of partitions
        int N = 1;

        while (Math.abs((current - prev) / current) > tolerance) {
            N *= 2;
            sum = 0;
            delta = (b - a) / N;

            for (int i = 0; i < N; i++) {
                x0 = a + i * delta;
                x1 = x0 + delta;

                sum += basicClosedNewtonCotesDegree2(function, x0, x1);
            }

            prev = current;
            current = sum;
        }

        return current;
    }

    public static double closedToleranceNewtonCotesDegree3(Function function, double a, double b, double tolerance) {
        double current, prev, sum, delta, x0, x1;

        current = 0.1;
        prev = 100;

        int N = 1;

        while (Math.abs((current - prev) / current) > tolerance) {
            N *= 2;
            sum = 0;
            delta = (b - a) / N;

            for (int i = 0; i < N; i++) {
                x0 = a + i * delta;
                x1 = x0 + delta;

                sum += basicClosedNewtonCotesDegree3(function, x0, x1);
            }

            prev = current;
            current = sum;
        }

        return current;
    }

    public static double closedToleranceNewtonCotesDegree4(Function function, double a, double b, double tolerance) {
        double current, prev, sum, delta, x0, x1;

        current = 0.1;
        prev = 100;

        int N = 1;

        while (Math.abs((current - prev) / current) > tolerance) {
            N *= 2;
            sum = 0;
            delta = (b - a) / N;

            for (int i = 0; i < N; i++) {
                x0 = a + i * delta;
                x1 = x0 + delta;

                sum += basicClosedNewtonCotesDegree4(function, x0, x1);
            }

            prev = current;
            current = sum;
        }

        return current;
    }
}
