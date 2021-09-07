package tesky.mn2.initialvalueproblem;

import tesky.mn2.util.Matrix;
import tesky.mn2.util.Result;
import tesky.mn2.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class ResultInitialValueProblem implements Result {

    Vector x;
    Vector exactResult;

    public ResultInitialValueProblem(Vector x, Vector newVector) {
        this.x = x;
        this.exactResult = newVector;
    }

    @Override
    public Double getEigenvalue() {
        return null;
    }

    @Override
    public Vector getEigenvector() {
        return null;
    }

    @Override
    public List<Matrix> getHouseholderResult() {
        return null;
    }

    @Override
    public Matrix getQRResultMatrix() {
        return null;
    }

    @Override
    public Vector getQRResultLambdasVector() {
        return null;
    }

    @Override
    public List<Vector> getVectorsByBoundaryValueProblem() {
        List<Vector> result = new ArrayList<>();
        result.add(x);
        result.add(exactResult);
        return result;
    }
}
