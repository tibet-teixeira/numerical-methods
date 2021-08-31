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

    public Double get(int i) {
        return vector.get(i);
    }

    public Double set(int i, Double value) {
        return vector.set(i, value);
    }

    public int size() {
        return vector.size();
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

    public static void swap(Vector vector, int i, int j) {
        Double aux = vector.get(i);
        vector.set(i, vector.get(j));
        vector.set(j, aux);
    }

    public Vector scalarMultiplication(double scalar) {
        Vector scalarVector = new Vector(this);
        for (int element = 0; element < this.size(); element++) {
            scalarVector.set(element, this.get(element) * scalar);
        }
        return scalarVector;
    }

    public Vector vectorSubtraction(Vector anotherVector) {
        int size = this.size();
        Vector subVector = new Vector(size);

        for (int element = 0; element < size; element++) {
            subVector.set(element, this.get(element) - anotherVector.get(element));
        }

        return subVector;
    }

    @Override
    public String toString() {
        return this.vector.toString();
    }
}
