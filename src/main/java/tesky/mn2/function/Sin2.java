package tesky.mn2.function;

public class Sin2 implements Function {
    @Override
    public double f(double x) {
        return Math.pow((Math.sin(2 * x) + 4 * Math.pow(x, 2) + 3 * x), 2);
    }
}
