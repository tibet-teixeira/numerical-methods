package tesky.mn2.eigenvalues;

import tesky.mn2.Eigenvalue;
import tesky.mn2.util.Matrix;
import tesky.mn2.util.Vector;

public class Main {
    public static void main(String[] args) {
        executeExercise10();
    }

    private static void executeExercise10() {
        Matrix matrix3x3 = new Matrix(
                new Vector(5.0, 2.0, 1.0),
                new Vector(2.0, 3.0, 1.0),
                new Vector(1.0, 1.0, 2.0));

        Matrix matrix5x5 = new Matrix(
                new Vector(40.0, 8.0, 4.0, 2.0, 1.0),
                new Vector(8.0, 30.0, 12.0, 6.0, 2.0),
                new Vector(4.0, 12.0, 20.0, 1.0, 2.0),
                new Vector(2.0, 6.0, 1.0, 25.0, 4.0),
                new Vector(1.0, 2.0, 2.0, 4.0, 5.0));

        Vector vector3x3 = new Vector(1.0, 1.0, 1.0);
        Vector vector5x5 = new Vector(1.0, 1.0, 1.0, 1.0, 1.0);

        System.out.println("Matriz 3x3");
        Eigenvalue.calculate(matrix3x3, vector3x3, 0.000001);
        System.out.println();

        System.out.println("Matriz 5x5");
        Eigenvalue.calculate(matrix5x5, vector5x5, 0.000001);
    }
}