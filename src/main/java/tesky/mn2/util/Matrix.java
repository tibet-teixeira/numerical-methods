package tesky.mn2.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {
    public List<Vector> matrix;

    public Matrix(int n) {
        matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matrix.add(new Vector(n));
        }
    }

    public Matrix(Vector... vectors) {
        matrix = new ArrayList<>();
        this.matrix.addAll(Arrays.asList(vectors));
    }

    public Matrix(Matrix matrix) {
        this.matrix = new ArrayList<>();
        this.matrix.addAll(matrix.matrix);
    }

    public static Matrix identity(int n) {
        Matrix identityMatrix = new Matrix(n);

        for (int i = 0; i < n; i++) {
            identityMatrix.set(i, i, (double) 1);
        }

        return identityMatrix;
    }

    public Vector vectorMultiplication(Vector vector) {
        Vector multiVector = new Vector();

        for (Vector row : this.matrix) {
            multiVector.add(row.dotProduct(vector));
        }

        return multiVector;
    }

    public Double get(int i, int j) {
        return matrix.get(i).get(j);
    }

    public void set(int i, int j, Double value) {
        matrix.get(i).set(j, value);
    }

    public int size() {
        return matrix.size();
    }

    public static void swap(Matrix A, int i, int j, int k, int l) {
        Double aux = A.get(i, j);
        A.set(i, j, A.get(k, l));
        A.set(k, l, aux);
    }

    public Matrix inverse() {
        Matrix identityMatrix = Matrix.identity(this.size());
        int i, j, k;
        Double pivot, m;

        for (j = 0; j < this.size(); j++) {
            pivot = this.get(j, j);
            for (k = 0; k < this.size(); k++) {
                this.set(j, k, this.get(j, k) / (pivot));
                identityMatrix.set(j, k, identityMatrix.get(j, k) / (pivot));
            }

            for (i = 0; i < this.size(); i++) {
                if (i != j) {
                    m = this.get(i, j);
                    for (k = 0; k < this.size(); k++) {
                        this.set(i, k, this.get(i, k) - (m * this.get(j, k)));
                        identityMatrix.set(i, k, identityMatrix.get(i, k) - (m * identityMatrix.get(j, k)));
                    }
                }
            }
        }

        return identityMatrix;
    }

    public Matrix matrixSubtraction(Matrix anotherMatrix) {
        int size = this.size();
        Matrix subMatrix = new Matrix(size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                subMatrix.set(row, col, this.get(row, col) - anotherMatrix.get(row, col));
            }
        }

        return subMatrix;
    }

    public Matrix transpose() {
        Matrix transposeMatrix = new Matrix(this.size());

        for (int row = 0; row < this.size(); row++) {
            for (int col = 0; col < this.size(); col++) {
                transposeMatrix.set(col, row, this.get(row, col));
            }
        }
        return transposeMatrix;
    }

    public Matrix scalarMultiplication(double scalar) {
        Matrix scalarMatrix = new Matrix(this);
        Vector scalarVector;
        for (int row = 0; row < this.size(); row++) {
            scalarVector = this.matrix.get(row).scalarMultiplication(scalar);
            for (int col = 0; col < this.size(); col++) {
                scalarMatrix.set(row, col, scalarVector.get(col));
            }
        }
        return scalarMatrix;
    }

    public Matrix matrixMultiplication(Matrix anotherMatrix) {
        Matrix matrixMult = new Matrix(this.size());
        int size = this.size();
        double result;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixMult.set(i, j, 0.);
                for (int k = 0; k < size; k++) {
                    result = matrixMult.get(i, j) + this.get(i, k) * anotherMatrix.get(k, j);
                    matrixMult.set(i, j, result);
                }
            }
        }

        return matrixMult;
    }

    public double sumSquareBelowDiagonal() {
        int size = this.size();
        double sum = 0;
        // TODO rever este calculo
        for (int col = 0; col < size - 1; col++) {
            sum += Math.pow(this.get(col + 1, col), 2);
        }
        return sum;
    }

    @Override
    public String toString() {
        return matrix.toString().replace("],", "]\n");
    }
}
