package tesky.mn2.eigenvalues;

import tesky.mn2.Eigenvalue;
import tesky.mn2.util.Matrix;
import tesky.mn2.util.Vector;

public class Main {
    public static void main(String[] args) {
        executeExercise10();
    }

    private static void executeExercise10() {
        Matrix matrix3x3 = new Matrix(new Vector(5.0, 2.0, 1.0),
                new Vector(2.0, 3.0, 1.0),
                new Vector(1.0, 1.0, 2.0));

//        Matrix matrix3x3 = new Matrix(new Vector(1.0, 2.0, 1.0),
//                new Vector(1.0, 1.0, 0.0),
//                new Vector(0.0, 1.0, 1.0));

        Vector vector3x3 = new Vector(1.0, 1.0, 1.0);

        Eigenvalue.calculate(matrix3x3, vector3x3, 0.000001);
    }
}