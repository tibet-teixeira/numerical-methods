package tesky.mn2.eigenvalues;

import tesky.mn2.util.Matrix;
import tesky.mn2.util.Result;
import tesky.mn2.util.Vector;

public class Eigenvalue {
    public static Result regularPower(Matrix matrix, Vector vector, double tolerance) {
        Result result = new EigenvalueEigenvector();
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

        result.setEigenvalueEigenvector(newLambda, oldVector);

        return result;
    }

    public static Result inversePower(Matrix matrix, Vector vector, double tolerance) {
        Result result = new EigenvalueEigenvector();
        double newLambda = 0;
        double oldLambda;
        Vector newVector = new Vector(vector);
        Vector oldVector = new Vector();
        Vector normalizedVector;
        Matrix inverseMatrix = matrix.inverse();

        do {
            oldLambda = newLambda;
            oldVector.copy(newVector);
            normalizedVector = oldVector.normalize();
            newVector = inverseMatrix.vectorMultiplication(normalizedVector);
            newLambda = normalizedVector.dotProduct(newVector);
        } while (Math.abs((newLambda - oldLambda) / newLambda) > tolerance);

        result.setEigenvalueEigenvector(1.0/newLambda, oldVector);

        return result;
    }
}
