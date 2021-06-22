package tesky.mn2.function;

public class Cos2 implements Function {
    @Override
    public double f(double x) {
        return Math.pow((Math.cos(2 * x)), 2);
    }
}
