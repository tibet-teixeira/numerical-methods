package tesky.mn2.eigenvalues;

import tesky.mn2.util.LU;
import tesky.mn2.util.Matrix;
import tesky.mn2.util.Result;
import tesky.mn2.util.Vector;

public class Eigenvalue {
    public static Result regularPower(Matrix matrix, Vector vector, double tolerance) {
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

        return new EigenvalueEigenvector(newLambda, normalizedVector);
    }

    public static Result inversePower(Matrix matrix, Vector vector, double tolerance) {
        Matrix inverseMatrix = matrix.inverse();
        Result result = regularPower(inverseMatrix, vector, tolerance);
        return new EigenvalueEigenvector(1.0 / result.getEigenvalue(), result.getEigenvector());
    }

    public static Result inversePowerLU(Matrix matrix, Vector vector, double tolerance) {
        double newLambda = 0;
        double oldLambda;
        Vector newVector = new Vector(vector);
        Vector oldVector = new Vector();
        Vector normalizedVector;

        do {
            oldLambda = newLambda;
            oldVector.copy(newVector);
            normalizedVector = oldVector.normalize();
            newVector = LU.solve(matrix, normalizedVector);
            newLambda = normalizedVector.dotProduct(newVector);
        } while (Math.abs((newLambda - oldLambda) / newLambda) > tolerance);

        return new EigenvalueEigenvector(1.0 / newLambda, normalizedVector);
    }

    public static Result shiftedPower(Matrix matrix, Vector vector, double u, double tolerance) {
        Matrix A_ = new Matrix(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            A_.set(i, i, matrix.get(i, i) - u);
        }

        Result inversePowerResult = inversePower(A_, vector, tolerance);
        Double lambda = inversePowerResult.getEigenvalue() + u;
        Vector x = inversePowerResult.getEigenvector();

        return new EigenvalueEigenvector(lambda, x);
    }
}
