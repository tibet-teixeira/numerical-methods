package tesky.mn2.eigenvalues;

import tesky.mn2.util.Matrix;
import tesky.mn2.util.Result;
import tesky.mn2.util.Vector;

public class Main {
    final static Matrix A1 = new Matrix(
            new Vector(5.0, 2.0, 1.0),
            new Vector(2.0, 3.0, 1.0),
            new Vector(1.0, 1.0, 2.0));

    final static Matrix A2 = new Matrix(
            new Vector(-14.0, 1.0, -2.0),
            new Vector(1.0, -1.0, 1.0),
            new Vector(-2.0, 1.0, -11.0));

    final static Matrix A3 = new Matrix(
            new Vector(40.0, 8.0, 4.0, 2.0, 1.0),
            new Vector(8.0, 30.0, 12.0, 6.0, 2.0),
            new Vector(4.0, 12.0, 20.0, 1.0, 2.0),
            new Vector(2.0, 6.0, 1.0, 25.0, 4.0),
            new Vector(1.0, 2.0, 2.0, 4.0, 5.0));

    final static Vector v1 = new Vector(1.0, 1.0, 1.0);
    final static Vector v3 = new Vector(1.0, 1.0, 1.0, 1.0, 1.0);

    public static void main(String[] args) {
//        executeExercise10();
//        executeExercise11InversePower();
        executeExercise11ShiftedPower();
    }

    private static void executeExercise10() {
        System.out.println("Matriz 3x3");
        Result result3x3 = Eigenvalue.regularPower(A1, v1, 0.000001);
        System.out.println("Autovalor: " + result3x3.getEigenvalue());
        System.out.println("Autovetor: " + result3x3.getEigenvector());

        System.out.println();

        System.out.println("Matriz 5x5");
        Result result5x5 = Eigenvalue.regularPower(A3, v3, 0.000001);
        System.out.println("Autovalor: " + result5x5.getEigenvalue());
        System.out.println("Autovetor: " + result5x5.getEigenvector());
    }

    private static void executeExercise11InversePower() {
        System.out.println("Matriz A1");
        Result resultA1 = Eigenvalue.inversePower(A1, v1, 0.000001);
        System.out.println("Autovalor: " + resultA1.getEigenvalue());
        System.out.println("Autovetor: " + resultA1.getEigenvector());

        System.out.println();

        System.out.println("Matriz A2");
        Result resultA2 = Eigenvalue.inversePower(A2, v1, 0.000001);
        System.out.println("Autovalor: " + resultA2.getEigenvalue());
        System.out.println("Autovetor: " + resultA2.getEigenvector());

        System.out.println();

        System.out.println("Matriz A3");
        Result resultA3 = Eigenvalue.inversePower(A3, v3, 0.000001);
        System.out.println("Autovalor: " + resultA3.getEigenvalue());
        System.out.println("Autovetor: " + resultA3.getEigenvector());
    }

    private static void executeExercise11ShiftedPower() {
        System.out.println("Matriz A1");
        Result resultA1 = Eigenvalue.shiftedPower(A1, v1, 1.8, 0.000001);
        System.out.println("Autovalor: " + resultA1.getEigenvalue());
        System.out.println("Autovetor: " + resultA1.getEigenvector());

        System.out.println();

        System.out.println("Matriz A2");
        Result resultA2 = Eigenvalue.shiftedPower(A2, v1, -1.0, 0.000001);
        System.out.println("Autovalor: " + resultA2.getEigenvalue());
        System.out.println("Autovetor: " + resultA2.getEigenvector());

        System.out.println();

        System.out.println("Matriz A3");
        Result resultA3 = Eigenvalue.shiftedPower(A3, v3, 11.0, 0.000001);
        System.out.println("Autovalor: " + resultA3.getEigenvalue());
        System.out.println("Autovetor: " + resultA3.getEigenvector());
    }
}