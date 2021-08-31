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

    public static Result HouseholderMethod(Matrix matrixA) {
        Matrix Hi;
        int size = matrixA.size();
        Matrix H = Matrix.identity(size);
        Matrix matrixAim1 = new Matrix(matrixA);
        Matrix matrixAi = new Matrix(size);

        for (int i = 0; i < size - 2; i++) {
            Hi = HouseholderMethodAux(matrixAim1, i);
            matrixAi = Hi.transpose().matrixMultiplication(matrixAim1).matrixMultiplication(Hi);
            matrixAim1 = new Matrix(matrixAi);
            H = H.matrixMultiplication(Hi);
        }

        Matrix A_ = new Matrix(matrixAi);
        return new EigenvalueEigenvector(A_, H);
    }


    private static Matrix HouseholderMethodAux(Matrix matrixA, int i) {
        int size = matrixA.size();
        Vector w = new Vector(size);
        Vector wl = new Vector(size);

        for (int x = i + 1; x < size; x++) {
            w.set(x, matrixA.get(x, i));
        }

        double Lw = w.normCalculate();
        wl.set(i + 1, Lw);

        Vector N = w.vectorSubtraction(wl);
        Vector n = N.normalize();

        Matrix matrixN = new Matrix(size);

        for (int index = 0; index < size; index++) {
            matrixN.set(index, 0, n.get(index));
        }

        // matrixAux = n * nT
        Matrix matrixAux = new Matrix(matrixN.matrixMultiplication(matrixN.transpose()));
        return Matrix.identity(size).matrixSubtraction(matrixAux.scalarMultiplication(2)); // Matrix H
    }

    public static Result QRMethod(Matrix matrixA, double tolerance) {
        return QRMethod(matrixA, tolerance, false);
    }

    public static Result QRMethod(Matrix matrixA, double tolerance, boolean householderAdaptation) {
        int size = matrixA.size();
        Matrix matrixQ;
        Matrix matrixR;
        Matrix matrixANew = new Matrix(size);
        Matrix matrixAOld = new Matrix(matrixA);
        Matrix matrixP = Matrix.identity(size);
        Matrix matrixH = new Matrix(size);

        Vector lambdas = new Vector();
        double val = tolerance + 1;

        if(householderAdaptation) {
            Result householderMethodResults = HouseholderMethod(matrixA);
            matrixAOld = householderMethodResults.getHouseholderResult().get(0);
            matrixH = householderMethodResults.getHouseholderResult().get(1);
        }

        while (val > tolerance) {
            Result qrDecompositionResult = QRDecomposition(matrixAOld);
            matrixQ = qrDecompositionResult.getHouseholderResult().get(0);
            matrixR = qrDecompositionResult.getHouseholderResult().get(1);

            matrixANew = matrixR.matrixMultiplication(matrixQ);
            matrixAOld = new Matrix(matrixANew);
            matrixP = matrixP.matrixMultiplication(matrixQ);

            val = matrixANew.sumSquareBelowDiagonal();
        }

        for (int i = 0; i < matrixANew.size(); i++) {
            lambdas.add(matrixANew.get(i, i));
        }

        if(householderAdaptation)
            matrixP = matrixH.matrixMultiplication(matrixP);


        return new EigenvalueEigenvector(matrixP, lambdas);
    }


    private static Result QRDecomposition(Matrix matrixA) {
        int size = matrixA.size();
        Matrix matrixJij;
        Matrix matrixQT = Matrix.identity(size);
        Matrix matrixRNew = new Matrix(size);
        Matrix matrixROld = new Matrix(matrixA);

        for (int col = 0; col < size - 1; col++) {
            for (int row = col + 1; row < size; row++) {
                matrixJij = jacobiMatrixBasedOn_ij_ElementOfROld(matrixROld, row, col);
                matrixRNew = matrixJij.matrixMultiplication(matrixROld);
                matrixROld = new Matrix(matrixRNew);
                matrixQT = matrixJij.matrixMultiplication(matrixQT);
            }
        }

        return new EigenvalueEigenvector(matrixQT.transpose(), matrixRNew);
    }

    private static Matrix jacobiMatrixBasedOn_ij_ElementOfROld(Matrix matrixA, int row, int col) {
        int size = matrixA.size();
        Matrix matrixJij = Matrix.identity(size);

        double omega;
        double tolerance = Math.pow(10, -6);

        if (Math.abs(matrixA.get(row, col)) <= tolerance)
            return matrixJij;

        if (Math.abs(matrixA.get(col, col)) <= tolerance) {
            if (matrixA.get(row, col) < 0) {
                omega = Math.PI / 2;
            } else {
                omega = -Math.PI / 2;
            }
        } else {
            omega = Math.atan((-matrixA.get(row, col)) / matrixA.get(col, col));
        }

        matrixJij.set(row, row, Math.cos(omega));
        matrixJij.set(col, col, Math.cos(omega));
        matrixJij.set(row, col, Math.sin(omega));
        matrixJij.set(col, row, -Math.sin(omega));

        return matrixJij;
    }

}
