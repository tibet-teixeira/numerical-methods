package tesky.mn2.function;

public class Exponential1 implements Function {

    @Override
    public double f(double x) {
        return 1/(Math.cbrt(Math.pow(x, 2)));
    }
}
