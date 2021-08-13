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

    public Vector vectorMultiplication(Vector vector){
        Vector multiVector = new Vector();

        for (Vector row : this.matrix) {
            multiVector.add(row.dotProduct(vector));
        }

        return multiVector;
    }

    @Override
    public String toString() {
        return matrix.toString().replace("],", "]\n");
    }
}
