package functions;

import utility.ClosedInterval;
import utility.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denise Goldan on 10/7/2016.
 */
public class MinimumFinder {

    private static final double MAXIMUM_NUMBER_OF_STEPS = 1000;
    private static final double STEP_LENGTH = 0.01;
    private static final double NUMBER_OF_TRIES = 1000;

    private double bestSolution = Integer.MAX_VALUE;
    private List<Double> bestSolutionVariables = new ArrayList<>();

    private int maximumDepth;
    private Function targetedFunction;
    private int numberOfVariables;

    public static void main(String[] args) {
        Ackley function = new Ackley();
        MinimumFinder scout = new MinimumFinder();
        scout.searchBestConfiguration(function, 4, 3);
    }

    public void searchBestConfiguration(Function function, int desiredNumberOfVariables, int desiredDepth) {
        configureSearch(function, desiredNumberOfVariables, desiredDepth);
        for (int i = 0; i < NUMBER_OF_TRIES; i++) {
            executeTargetedFunction();
        }
        printBestConfiguration();
    }

    public void executeTargetedFunction() {
        List<Double> variables = RandomGenerator.getRandomVariableValueList(numberOfVariables, targetedFunction.getVariablesDomain());
        if (targetedFunction.getCalculationResult(variables) < bestSolution) {
           updateBestSolution(variables);
        }
        optimizeVariables(variables);
    }

    private void optimizeVariables(List<Double> variables) {
        for (int index = 0; index < numberOfVariables; index++) {
            optimizeIndex(0, variables, STEP_LENGTH, index);
        }
    }

    public void optimizeIndex(int currentDepth, List<Double> variables, double stepLength, int index) {
        if (currentDepth < maximumDepth) {
            ClosedInterval domain = getDomainForCurrentIndexVariable(index);
            searchLeft(currentDepth, variables, stepLength, index, domain);
            searchRight(currentDepth, variables, stepLength, index, domain);
        }
        currentDepth++;
    }

    private void searchRight(int currentDepth, List<Double> variables, double stepLength, int index, ClosedInterval domain) {
        int doneStepsToRight = 0;
        while (doneStepsToRight < MAXIMUM_NUMBER_OF_STEPS) {
            double bigger = variables.get(index) + stepLength;
            if (!ClosedInterval.isInsideClosedInterval(bigger, domain)) {
                break;
            }
            List<Double> searchVariables = getUpdatedList(variables, index, bigger);
            if (targetedFunction.getCalculationResult(searchVariables) < bestSolution) {
                updateBestSolution(searchVariables);
                optimizeIndex(++currentDepth, searchVariables, stepLength / 2, index);
            }
            doneStepsToRight++;
        }
    }

    private void searchLeft(int currentDepth, List<Double> variables, double stepLength, int index, ClosedInterval domain) {
        int doneStepsToLeft = 0;
        while (doneStepsToLeft < MAXIMUM_NUMBER_OF_STEPS) {
            double smaller = variables.get(index) - stepLength;
            if (!ClosedInterval.isInsideClosedInterval(smaller, domain)) {
                break;
            }
            List<Double> searchVariables = getUpdatedList(variables, index, smaller);
            if (targetedFunction.getCalculationResult(searchVariables) < bestSolution) {
                updateBestSolution(searchVariables);
                optimizeIndex(++currentDepth, searchVariables, stepLength / 2, index);
            }
            doneStepsToLeft++;
        }
    }

    private List<Double> getUpdatedList(List<Double> variables, int index, double smaller) {
        List<Double> leftCaseVariables = variables;
        leftCaseVariables.set(index, smaller);
        return leftCaseVariables;
    }

    public ClosedInterval getDomainForCurrentIndexVariable(int currentVariableIndex) {
        ClosedInterval currentIndexDomain;
        if (targetedFunction.getVariablesDomain().size() == 1) {
            currentIndexDomain = targetedFunction.getVariablesDomain().get(0);
        } else {
            currentIndexDomain = targetedFunction.getVariablesDomain().get(currentVariableIndex);
        }
        return currentIndexDomain;
    }

    private void updateBestSolution(List<Double> variables) {
        bestSolution =  targetedFunction.getCalculationResult(variables);
        bestSolutionVariables = variables;
    }

    private void configureSearch(Function function, int desiredNumberOfVariables, int desiredDepth) {
        setTargetedFunction(function);
        setNumberOfVariables(desiredNumberOfVariables);
        setMaximumDepth(desiredDepth);
    }

    private void setTargetedFunction(Function function) {
        targetedFunction = function;
    }

    public void setMaximumDepth(int desiredDepth) {
        if (desiredDepth < 1) {
            throw new AssertionError("The depth of the search must be higher than 0.");
        }
        maximumDepth = desiredDepth;
    }

    public void setNumberOfVariables(int desiredNumberOfVariables) {
        if (desiredNumberOfVariables < 1) {
            throw new AssertionError("The number of variables must be greater than 0.");
        }
        if (2 != numberOfVariables && targetedFunction.getFunctionName() == "SixHumpCamelBack function") {
            throw new RuntimeException(targetedFunction.getFunctionName() + " has only 2 variables. The desiredNumberOfVariables can only be equal to 2. ");
        }
        numberOfVariables = desiredNumberOfVariables;
    }

    public void printBestConfiguration() {
        System.out.println(targetedFunction.getFunctionName());
        System.out.println("f(x1,x2...xi)= " + bestSolution);
        for (int i = 0; i < bestSolutionVariables.size(); i++) {
            System.out.print("x" + i + ": " + bestSolutionVariables.get(i) + " ");
            System.out.println();
        }
    }
}
