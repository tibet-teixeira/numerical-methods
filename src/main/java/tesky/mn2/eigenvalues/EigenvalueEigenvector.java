package tesky.mn2.eigenvalues;

import tesky.mn2.util.Matrix;
import tesky.mn2.util.Result;
import tesky.mn2.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class EigenvalueEigenvector implements Result {
    public Double eigenvalue;
    public Vector eigenvector;
    public List<Matrix> QRMatrices;
    public Matrix matrixP;
    public Vector lambdas;

    public EigenvalueEigenvector(Matrix A, Matrix B) {
        this.QRMatrices = new ArrayList<>();
        QRMatrices.add(A);
        QRMatrices.add(B);
    }

    public EigenvalueEigenvector(Matrix P, Vector lambs) {
        matrixP = P;
        lambdas = lambs;
    }

    public EigenvalueEigenvector(Double eigenvalue, Vector eigenvector) {
        this.eigenvalue = eigenvalue;
        this.eigenvector = eigenvector;
    }

    @Override
    public Double getEigenvalue() {
        return eigenvalue;
    }

    @Override
    public Vector getEigenvector() {
        return eigenvector;
    }

    @Override
    public List<Matrix> getHouseholderResult() {
        return QRMatrices;
    }

    @Override
    public Matrix getQRResultMatrix() {
        return matrixP;
    }

    @Override
    public Vector getQRResultLambdasVector() {
        return lambdas;
    }
}
