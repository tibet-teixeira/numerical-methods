package tesky.mn2.function;

public class SimpleExponential implements Function {
    private Function function;
    private double a, b;

    public SimpleExponential(Function function, double a, double b) {
        this.function = function;
        this.a = a;
        this.b = b;
    }

    @Override
    public double f(double s) {
        double midpoint = (a + b) / 2;
        double h = (b - a) / 2;
        double dxDs = h * (1 / Math.pow(Math.cosh(s), 2));
        return function.f(midpoint + (h * Math.tanh(s))) * dxDs;
    }
}
