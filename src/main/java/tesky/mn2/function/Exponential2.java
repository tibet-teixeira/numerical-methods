package tesky.mn2.function;

public class Exponential2 implements Function {
    @Override
    public double f(double x) {
        return 1/(Math.sqrt(4 - Math.pow(x, 2)));
    }
}
