package tesky.mn2.integration;

import tesky.mn2.function.Function;

public class GaussChebyshev implements IntegrationMethod {

    public static double gaussChebyshevNPoints(Function function, int N) {
        double sum = 0;
        double x;
        double weight = Math.PI / N;

        for (int k = 1; k <= N; k++) {
            x = Math.cos(((2 * k - 1) / (2.0 * N)) * Math.PI);
            sum += function.f(x);
        }

        return weight * sum;
    }
}
