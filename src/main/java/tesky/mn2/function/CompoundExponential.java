package tesky.mn2.function;

public class CompoundExponential implements Function {
    private Function function;
    private double a, b;

    public CompoundExponential(Function function, double a, double b) {
        this.function = function;
        this.a = a;
        this.b = b;
    }

    @Override
    public double f(double s) {
        double midpoint = (a + b) / 2;
        double h = (b - a) / 2;
        double tanhParam = (Math.PI / 2) * Math.sinh(s);
        double dxDs = h * (Math.PI / 2) * (Math.cosh(2) / Math.pow(Math.cosh(tanhParam), 2));
        return function.f(midpoint + (h * Math.tanh(tanhParam))) * dxDs;
    }
}
