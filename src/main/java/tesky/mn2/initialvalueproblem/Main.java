package tesky.mn2.initialvalueproblem;

public class Main {
    public static void main(String[] args) {
        executeExercise13();
//        executeExercise14();
    }

    private static void executeExercise13() {
        InitialValueProblem.rungeKuttaMethod(200, 3, 150, 0.5, 0.5, 0.1, 0);

    }

    private static void executeExercise14() {
        InitialValueProblem.predictorCorrector(200, 3, 150, 0.5, 0.5, 0.1, 0, 0.000001);
    }
}
