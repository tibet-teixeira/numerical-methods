package tesky.mn2.initialvalueproblem;

import tesky.mn2.util.LU;
import tesky.mn2.util.Matrix;
import tesky.mn2.util.Result;
import tesky.mn2.util.Vector;

public class BoundaryValueProblem {
    public static double exactFunction(double x) {
        double numerador = Math.exp(-x) - Math.exp(x);
        double denominador = Math.exp(-1) - Math.exp(1);
        return numerador / denominador;
    }

    public static Result pvc1(int n) {
        Matrix matrizPVC = new Matrix();
        Vector result = new Vector(n - 1);
        double element = 1 / (1 / Math.pow(n, 2));
        for (int i = 0; i < n - 1; i++) {
            Vector line = new Vector();
            for (int j = 0; j < n - 1; j++) {
                if (i == j) {
                    line.add(-2 * element - 1);
                } else if (j == i - 1 || j == i + 1) {
                    line.add(element);
                } else {
                    line.add(0.);
                }
            }
            matrizPVC.add(line);
        }
        result.set(n - 2, -element);

        Matrix A = new Matrix(matrizPVC);
        System.out.println(A);
        Vector b = new Vector(result);
        Vector x = LU.solve(A, b);

        Vector exactResult = new Vector();
        for (int i = 0; i <  n - 1; i++) {
            exactResult.add(exactFunction((1. / n) * (i + 1)));
        }
        return new ResultInitialValueProblem(x, exactResult);
    }

    public static Vector pvc2(int n) {
        Matrix matrizPVC = new Matrix();
        Vector result = new Vector();
        double element = 1 / (1 / Math.pow(n, 2));
        for (int i = 0; i < Math.pow(n - 1, 2); i++) {
            Vector line = new Vector();
            result.add(4.);
            for (int j = 0; j < Math.pow(n - 1, 2); j++) {
                if (i == j) {
                    line.add(-4 * element);
                } else if (j == i - 1 || j == i + 1) {
                    line.add(element);
                } else if (j == i - 3 || j == i + 3) {
                    line.add(element);
                } else {
                    line.add(0.);
                }
            }
            matrizPVC.add(line);
        }
        Matrix A = new Matrix(matrizPVC);
        System.out.println(A);
        Vector b = new Vector(result);
        Vector x = LU.solve(A, b);
        return x;
    }

}
