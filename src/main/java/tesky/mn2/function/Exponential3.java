package tesky.mn2.function;

public class Exponential3 implements Function{
    @Override
    public double f(double x) {
        return Math.sqrt(Math.exp(3*x) + 4 * Math.pow(x, 2));
    }
}
