package tesky.mn2.util;

import java.util.List;

public interface Result {
    Double getEigenvalue();
    Vector getEigenvector();
    List<Matrix> getHouseholderResult();
    Matrix getQRResultMatrix();
    Vector getQRResultLambdasVector();
    List<Vector> getVectorsByBoundaryValueProblem();
}
