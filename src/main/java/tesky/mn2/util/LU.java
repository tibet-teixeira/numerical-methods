package tesky.mn2.util;

import java.util.ArrayList;
import java.util.List;

public class LU {
    private static List<Double> choosePivot(Matrix A, int k) {
        List<Double> result = new ArrayList<>();
        double pivot = Math.abs(A.get(k, k));
        double pv = A.get(k, k);
        int r = k;

        // Se o elemento da diagonal atual for o pivô real, vamos mantê-lo como pivô, o mesmo para o seu índice
        // fazemos a busca em toda matriz A se acharmos alguém maior que o pivô atualizamos o pivô para ele e
        // fazemos o mesmo para o seu indice
        for (int i = k + 1; i < A.size(); i++) {
            if (Math.abs(A.get(i, k)) > pivot) {

                pivot = Math.abs(A.get(i, k));
                pv = A.get(i, k);
                r = i;
            }
        }
        result.add(pv);
        result.add((double) r);
        return result;
    }

    // Faz a permutação mas não registra nada no vetor de permutação
    private static void fakePermute(Matrix A, int k, int r) {
        for (int j = 0; j < A.size(); j++)
            Matrix.swap(A, k, j, r, j);
    }


    // Faz a permutação de duas linhas da matriz A e registra a troca no vetor de permutação p
    private static void permute(Matrix A, Vector vectorB, int indexColunaK, int indexLinhaPivo) {
        Vector.swap(vectorB, indexColunaK, indexLinhaPivo);

        for (int indexColunaJ = 0; indexColunaJ < A.size(); indexColunaJ++)
            Matrix.swap(A, indexColunaK, indexColunaJ, indexLinhaPivo, indexColunaJ);
    }

    // Ux = y
    private static Vector retroactiveIterations(Matrix matrixU, Vector vectorY) {
        Vector vectorX = new Vector(vectorY.size());

        // Resolve o ultimo X da solução através de uma simples divisão
        vectorX.set(vectorY.size() - 1, vectorY.get(matrixU.size() - 1) / matrixU.get(matrixU.size() - 1, matrixU.size() - 1));
        double sum;

        // Itera sobre a matriz, linha por linha, calculando os Xs da resposta e registra o valor no vetor X
        for (int linhaIndexI = matrixU.size() - 1; linhaIndexI >= 0; linhaIndexI--) {
            sum = 0;
            for (int colunaIndexJ = linhaIndexI + 1; colunaIndexJ < matrixU.size(); colunaIndexJ++) {
                sum += matrixU.get(linhaIndexI, colunaIndexJ) * vectorX.get(colunaIndexJ);
            }
            vectorX.set(linhaIndexI, (vectorY.get(linhaIndexI) - sum) / matrixU.get(linhaIndexI, linhaIndexI));
        }

        return vectorX;
    }

    // Ly = b
    private static Vector successiveIterations(Matrix matrixL, Vector vectorB) {
        Vector vectorY = new Vector(vectorB.size());
        vectorY.set(0, vectorB.get(0) / matrixL.get(0, 0));
        double sum;

        for (int linhaIndexI = 1; linhaIndexI < vectorB.size(); linhaIndexI++) {
            sum = 0;
            for (int colunaIndexJ = 0; colunaIndexJ < vectorB.size(); colunaIndexJ++) {
                sum += matrixL.get(linhaIndexI, colunaIndexJ) * vectorY.get(colunaIndexJ);
            }

            vectorY.set(linhaIndexI, (vectorB.get(linhaIndexI) - sum) / matrixL.get(linhaIndexI, linhaIndexI));
        }

        return vectorY;
    }

    public static Vector solve(Matrix matrixA, Vector vectorB) {
        int size = matrixA.size();
        double calculateL, calculateU;
        Matrix matrixL = new Matrix(size);
        Matrix matrixU = new Matrix(size);

        // calculate L matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j < i) {
                    matrixL.set(j, i, 0.);
                } else {
                    matrixL.set(j, i, matrixA.get(j, i));
                    for (int k = 0; k < i; k++) {
                        calculateL = matrixL.get(j, i) - matrixL.get(j, k) * matrixU.get(k, i);
                        matrixL.set(j, i, calculateL);
                    }
                }
            }

            // calculate U matrix
            for (int j = 0; j < size; j++) {
                if (j < i) {
                    matrixU.set(i, j, 0.);
                } else if (j == i) {
                    matrixU.set(i, j, 1.);
                } else {
                    calculateU = matrixA.get(i, j) / matrixL.get(i, i);
                    matrixU.set(i, j, calculateU);
                    for (int k = 0; k < i; k++) {
                        calculateU = matrixU.get(i, j) - ((matrixL.get(i, k) * matrixU.get(k, j)) / matrixL.get(i, i));
                        matrixU.set(i, j, calculateU);
                    }
                }
             }
        }

        Vector y = successiveIterations(matrixL, vectorB);
        return retroactiveIterations(matrixU, y);
    }
}
