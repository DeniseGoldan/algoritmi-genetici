package functions;

import utility.ClosedInterval;
import utility.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denise Goldan on 10/7/2016.
 */
public class MinimumFinder {

    private MinimumFinderConfiguration configuration;

    private Function targetedFunction;

    private double bestSolution = Integer.MAX_VALUE;

    private List<Double> bestSolutionVariables = new ArrayList<>();

    public void searchBestSolution(Function function, int desiredNumberOfVariables) {
        configureSearch(function, desiredNumberOfVariables);
        List<Double> variables = RandomGenerator.getRandomVariableValueList(desiredNumberOfVariables, targetedFunction.getVariablesDomain());
        executeTargetedFunction(variables);
    }
    public void executeTargetedFunction(List<Double> variables) {
        double result = targetedFunction.getCalculationResult(variables);
        if (result < bestSolution) {
            updateBestSolution(variables, result);
        }
        optimizeVariables(variables);
    }

    public void optimizeVariables(List<Double> variables) {
        for (int index = 0; index < variables.size(); index++) {
            optimizeIndex(0, variables, index);
        }
    }

    public void optimizeIndex(int currentDepth, List<Double> variables, int index) {
        if (currentDepth < configuration.getMaximumDepth()) {
            ClosedInterval domain = getDomainForCurrentIndexVariable(index);
            searchLeft(currentDepth, variables, index);
            searchRight(currentDepth, variables, index);
        }
        currentDepth++;
    }

    public void searchRight(int currentDepth, List<Double> variables, int index) {
        ClosedInterval domain = getDomainForCurrentIndexVariable(index);
        double stepLength = calculateStepLength(currentDepth);
        int doneSteps = 0;
        while (doneSteps < configuration.getNumberOfSteps()) {
            double bigger = variables.get(index) + stepLength;
            if (!ClosedInterval.isInsideClosedInterval(bigger, domain)) {
                break;
            }
            List<Double> searchVariables = getUpdatedList(variables, index, bigger);
            double result = targetedFunction.getCalculationResult(searchVariables);
            if (targetedFunction.getCalculationResult(searchVariables) < bestSolution) {
                updateBestSolution(searchVariables, result);
                optimizeIndex(++currentDepth, searchVariables, index);
            }
            doneSteps++;
        }
    }

    public void searchLeft(int currentDepth, List<Double> variables, int index) {
        ClosedInterval domain = getDomainForCurrentIndexVariable(index);
        double stepLength = calculateStepLength(currentDepth);
        int doneSteps = 0;
        while (doneSteps < configuration.getNumberOfSteps()) {
            double smaller = variables.get(index) - stepLength;
            if (!ClosedInterval.isInsideClosedInterval(smaller, domain)) {
                break;
            }
            List<Double> searchVariables = getUpdatedList(variables, index, smaller);
            double result = targetedFunction.getCalculationResult(searchVariables);
            if (result < bestSolution) {
                updateBestSolution(searchVariables, result);
                optimizeIndex(++currentDepth, searchVariables, index);
            }
            doneSteps++;
        }
    }

    public double calculateStepLength(int currentDepth) {
        double stepLength;
        if (currentDepth < 0) {
            throw new AssertionError("The currentDepth can not be a negative number!");
        }
        if (0 == currentDepth) {
            stepLength = configuration.getStepLength();
        } else {
            stepLength = configuration.getStepLength() * Math.pow(0.75, currentDepth);
        }
        return stepLength;
    }

    public MinimumFinderConfiguration getConfiguration() {
        return configuration;
    }

    public List<Double> getUpdatedList(List<Double> variables, int index, double smaller) {
        List<Double> updatedVariables = new ArrayList<>(variables);
        updatedVariables.set(index, smaller);
        return updatedVariables;
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

    public void updateBestSolution(List<Double> variables, double result) {
        bestSolution = result;
        bestSolutionVariables = new ArrayList<>(variables);
    }

    public void configureSearch(Function function, int desiredNumberOfVariables) {
        setTargetedFunction(function);
        configuration = new MinimumFinderConfiguration();
        configuration.configureSearch(function, desiredNumberOfVariables);
    }

    public void setTargetedFunction(Function function) {
        targetedFunction = function;
    }

    public double getBestSolution() {
        return bestSolution;
    }

    public List<Double> getBestSolutionVariables() {
        return bestSolutionVariables;
    }

    public void printBestConfiguration() {
        System.out.println(targetedFunction.getFunctionName());
        System.out.println();
        System.out.println("f(x1,x2...xi) = " + bestSolution);
        for (int i = 0; i < bestSolutionVariables.size(); i++) {
            System.out.print("x" + i + ": " + bestSolutionVariables.get(i) + " ");
            System.out.println();
        }
    }

    public String getTargetedFunctionName() {
        return targetedFunction.getFunctionName();
    }
}
