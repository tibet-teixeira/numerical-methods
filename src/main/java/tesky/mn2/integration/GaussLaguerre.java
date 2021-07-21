package tesky.mn2.integration;

import tesky.mn2.function.Function;

public class GaussLaguerre implements IntegrationMethod {

    public static double gaussLaguerre2Points(Function function) {
        double p1 = 0.58578643;
        double p2 = 3.41421356;

        double w1 = 0.85355339;
        double w2 = 0.14644660;

        return (w1 * function.f(p1)
                + w2 * function.f(p2));
    }

    public static double gaussLaguerre3Points(Function function) {
        double p1 = 0.41577455;
        double p2 = 2.24428036;
        double p3 = 6.28994508;

        double w1 = 0.71109300;
        double w2 = 0.27851973;
        double w3 = 0.01038926;

        return (w1 * function.f(p1)
                + w2 * function.f(p2)
                + w3 * function.f(p3));
    }

    public static double gaussLaguerre4Points(Function function) {
        double p1 = 0.32254768;
        double p2 = 1.74576110;
        double p3 = 4.53662029;
        double p4 = 9.39507091;

        double w1 = 0.60315410;
        double w2 = 0.35741869;
        double w3 = 0.03888791;
        double w4 = 0.00053929;

        return (w1 * function.f(p1)
                + w2 * function.f(p2)
                + w3 * function.f(p3)
                + w4 * function.f(p4));
    }
}
