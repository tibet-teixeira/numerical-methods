package tesky.mn2.integration;

import tesky.mn2.function.Function;

public class GaussHermite implements IntegrationMethod {
    public static double gaussHermite2Points(Function function) {
        double p1 = -0.70710678;
        double p2 = 0.70710678;

        double w1 = 0.88622692;
        double w2 = 0.88622692;

        return (w1 * function.f(p1)
                + w2 * function.f(p2));
    }

    public static double gaussHermite3Points(Function function) {
        double p1 = -1.22474487;
        double p2 = 0.00000000;
        double p3 = 1.22474487;

        double w1 = 0.29540897;
        double w2 = 1.18163590;
        double w3 = 0.29540897;

        return (w1 * function.f(p1)
                + w2 * function.f(p2)
                + w3 * function.f(p3));
    }

    public static double gaussHermite4Points(Function function) {
        double p1 = -1.65068012;
        double p2 = -0.52464762;
        double p3 = 0.52464762;
        double p4 = 1.65068012;

        double w1 = 0.08131283;
        double w2 = 0.80491409;
        double w3 = 0.80491409;
        double w4 = 0.08131283;

        return (w1 * function.f(p1)
                + w2 * function.f(p2)
                + w3 * function.f(p3)
                + w4 * function.f(p4));
    }
}
