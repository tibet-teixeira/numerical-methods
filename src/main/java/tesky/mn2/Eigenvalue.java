package tesky.mn2;

import tesky.mn2.util.Matrix;
import tesky.mn2.util.Vector;

public class Eigenvalue {
    public static void calculate(Matrix matrix, Vector vector, double tolerance) {
        double newLambda = 0;
        double oldLambda;
        Vector newVector = new Vector(vector);
        Vector oldVector = new Vector();
        Vector normalizedVector;

        do {
            oldLambda = newLambda;
            oldVector.copy(newVector);
            normalizedVector = oldVector.normalize();
            newVector = matrix.vectorMultiplication(normalizedVector);
            newLambda = normalizedVector.dotProduct(newVector);
        } while (Math.abs((newLambda - oldLambda) / newLambda) > tolerance);

        System.out.println("Autovalor: " + newLambda);
        System.out.println("Autovetor: " + oldVector);
    }
}
