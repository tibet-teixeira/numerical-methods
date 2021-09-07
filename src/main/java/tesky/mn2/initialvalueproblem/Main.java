package tesky.mn2.initialvalueproblem;

import tesky.mn2.util.Result;
import tesky.mn2.util.Vector;

public class Main {
    public static void main(String[] args) {
//        executeExercise13();
//        executeExercise14();
        executeExercise15();
    }

    private static void executeExercise13() {
        InitialValueProblem.rungeKuttaMethod(200, 3, 150, 0.5, 0.5, 0.1, 0);

    }

    private static void executeExercise14() {
        InitialValueProblem.predictorCorrector(200, 3, 150, 0.5, 0.5, 0.1, 0, 0.000001);
    }

    private static void executeExercise15() {
        Result result = BoundaryValueProblem.pvc1(8);

        Vector pvc2 = BoundaryValueProblem.pvc2(8);

        System.out.println("pvc1 result");
        System.out.println("Resultado aproximado " + result.getVectorsByBoundaryValueProblem().get(0));
        System.out.println("Resultado exato " + result.getVectorsByBoundaryValueProblem().get(1));
        System.out.println();

        System.out.println("pvc2 result");
        System.out.println(pvc2);
    }
}
