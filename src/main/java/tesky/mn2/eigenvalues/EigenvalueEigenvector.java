package tesky.mn2.eigenvalues;

import tesky.mn2.util.Result;
import tesky.mn2.util.Vector;

public class EigenvalueEigenvector implements Result {
    public Double eigenvalue;
    public Vector eigenvector;

    @Override
    public void setEigenvalueEigenvector(Double eigenvalue, Vector eigenvector) {
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
}
