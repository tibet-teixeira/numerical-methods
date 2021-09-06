package tesky.mn2.derivate;

import tesky.mn2.function.Function;

public class DerivateMethods {

    public static double taylorSeriesDerivateSecond(Function function, double x) {
        double delta = Math.pow(10, -4);
        double c1 = -1 / 12.;
        double c2 = 4 / 3.;
        double c3 = 4 / 3.;
        double c4 = -1 / 12.;
        double c5 = -5 / 2.;
        double error = ((1 / 90.) * Math.pow(function.f(x), 6) * Math.pow(delta, 4));
        return (1 / (Math.pow(delta, 2))) *
                (c1 * function.f(x + 2 * delta)
                        + c2 * function.f(x + delta)
                        + c3 * function.f(x - delta)
                        + c4 * function.f(x - 2 * delta)
                        + c5 * function.f(x))
                + error;
    }

    public static double newtonPolynomialDerivateSecond(Function function, double x) {
        double delta = Math.pow(10, -4);
        return 1 / Math.pow(delta, 2) * (function.f(x - delta) - 2 * function.f(x) + function.f(x + delta));
    }

}
