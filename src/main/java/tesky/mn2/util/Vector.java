package tesky.mn2.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vector {
    public List<Double> vector;

    public Vector() {
        vector = new ArrayList<>();
    }

    public Vector(int n) {
        vector = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vector.add(0.0);
        }
    }

    public Vector(Double... values) {
        vector = new ArrayList<>();
        vector.addAll(Arrays.asList(values));
    }

    public Vector(Vector vector) {
        this.vector = new ArrayList<>();
        this.vector.addAll(vector.vector);
    }

    public void add(Double value) {
        this.vector.add(value);
    }

    public Double normCalculate() {
        Double normValue = 0.0;

        for (Double value : this.vector) {
            normValue += Math.pow(value, 2);
        }

        return Math.sqrt(normValue);
    }

    public Vector normalize() {
        Vector normalizedVector = new Vector();
        Double norm = normCalculate();

        for (Double value : this.vector) {
            normalizedVector.add(value/norm);
        }

        return normalizedVector;
    }

    public void copy(Vector vector) {
        this.vector.clear();
        this.vector.addAll(vector.vector);
    }

    public Double dotProduct(Vector vector) {
        Double product = 0.0;
        for (int i = 0; i < this.vector.size(); i++) {
            product += this.vector.get(i) * vector.vector.get(i);
        }

        return product;
    }

    @Override
    public String toString() {
        return this.vector.toString();
    }
}
