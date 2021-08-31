package tesky.mn2.eigenvalues;

import tesky.mn2.util.Matrix;
import tesky.mn2.util.Result;
import tesky.mn2.util.Vector;

public class Main {
    final static Matrix A1 = new Matrix(
            new Vector(5., 2., 1.),
            new Vector(2., 3., 1.),
            new Vector(1., 1., 2.));

    final static Matrix A2 = new Matrix(
            new Vector(-14., 1., -2.),
            new Vector(1., -1., 1.),
            new Vector(-2., 1., -11.));

    final static Matrix A3 = new Matrix(
            new Vector(40., 8., 4., 2., 1.),
            new Vector(8., 30., 12., 6., 2.),
            new Vector(4., 12., 20., 1., 2.),
            new Vector(2., 6., 1., 25., 4.),
            new Vector(1., 2., 2., 4., 5.));

    final static Vector v1 = new Vector(1., 1., 1.);
    final static Vector v3 = new Vector(1., 1., 1., 1., 1.);

    final static double TOLERANCE = 0.00001;

    public static void main(String[] args) {
//        executeExercise10();
//        executeExercise11InversePower();
//        executeExercise11ShiftedPower();
        executeExercise12();
    }

    private static void executeExercise10() {
        System.out.println("Matriz 3x3");
        Result resultA1 = Eigenvalue.regularPower(A1, v1, TOLERANCE);
        System.out.println("Autovalor: " + resultA1.getEigenvalue());
        System.out.println("Autovetor: " + resultA1.getEigenvector());

        System.out.println();

        System.out.println("Matriz 5x5");
        Result resultA3 = Eigenvalue.regularPower(A3, v3, TOLERANCE);
        System.out.println("Autovalor: " + resultA3.getEigenvalue());
        System.out.println("Autovetor: " + resultA3.getEigenvector());
    }

    private static void executeExercise11InversePower() {
        System.out.println("Matriz A1");
        Result resultA1 = Eigenvalue.inversePowerLU(A1, v1, TOLERANCE);
        System.out.println("Autovalor: " + resultA1.getEigenvalue());
        System.out.println("Autovetor: " + resultA1.getEigenvector());

        System.out.println();

        System.out.println("Matriz A2");
        Result resultA2 = Eigenvalue.inversePower(A2, v1, TOLERANCE);
        System.out.println("Autovalor: " + resultA2.getEigenvalue());
        System.out.println("Autovetor: " + resultA2.getEigenvector());

        System.out.println();

        System.out.println("Matriz A3");
        Result resultA3 = Eigenvalue.inversePower(A3, v3, TOLERANCE);
        System.out.println("Autovalor: " + resultA3.getEigenvalue());
        System.out.println("Autovetor: " + resultA3.getEigenvector());
    }

    private static void executeExercise11ShiftedPower() {
        System.out.println("Matriz A1");
        Result resultA1 = Eigenvalue.shiftedPower(A1, v1, 1.8, TOLERANCE);
        System.out.println("Autovalor: " + resultA1.getEigenvalue());
        System.out.println("Autovetor: " + resultA1.getEigenvector());

        System.out.println();

        System.out.println("Matriz A2");
        Result resultA2 = Eigenvalue.shiftedPower(A2, v1, -1., TOLERANCE);
        System.out.println("Autovalor: " + resultA2.getEigenvalue());
        System.out.println("Autovetor: " + resultA2.getEigenvector());

        System.out.println();

        System.out.println("Matriz A3");
        Result resultA3 = Eigenvalue.shiftedPower(A3, v3, 11., TOLERANCE);
        System.out.println("Autovalor: " + resultA3.getEigenvalue());
        System.out.println("Autovetor: " + resultA3.getEigenvector());
    }

    public static void executeExercise12() {
        System.out.println("Matriz A1");
        Result resultA1 = Eigenvalue.QRMethod(A1, TOLERANCE, true);

        Vector lambdas = resultA1.getQRResultLambdasVector();
        Matrix matrixP = resultA1.getQRResultMatrix().transpose(); // calcula a transposta apenas para facilitar a visualização por vetores

        int lambda = 0;
        for (Vector eigenVector : matrixP.matrix) {
            System.out.println("Autovetor associado ao autovalor " + lambdas.get(lambda) + ": " + eigenVector);
            lambda++;
        }
    }
}