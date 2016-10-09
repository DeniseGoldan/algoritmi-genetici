package functions;

import utility.ClosedInterval;

/**
 * Created by Denise Goldan on 10/9/2016.
 */
public class MinimumFinderConfiguration {

    private static final int MAXIMUM_DEPTH = 6;
    private static final int PRECISION = 1000;
    private int numberOfVariables;
    private double stepLength;
    private double numberOfSteps;

    public void configureSearch(Function function, int desiredNumberOfVariables) {
        setNumberOfVariables(function, desiredNumberOfVariables);
        setStepLength(function);
        setNumberOfSteps();
    }

    private  void setNumberOfVariables(Function function, int desiredNumberOfVariables) {
        if (desiredNumberOfVariables <= 0) {
            throw new AssertionError("The number of variables must be greater than 0.");
        }
        if (function.getFunctionName().equals("Six Hump Camel Back function")&& desiredNumberOfVariables != 2 ) {
            throw new RuntimeException(function.getFunctionName() + " has only 2 variables. The desiredNumberOfVariables can only be equal to 2. " + desiredNumberOfVariables + " = the given number.");
        }
        numberOfVariables = desiredNumberOfVariables;
    }

    private void setStepLength(Function function) {
        ClosedInterval domain = function.getVariablesDomain().get(0);
        stepLength = (domain.getSecondEndpoint() - domain.getFirstEndpoint())/PRECISION;
    }

    private void setNumberOfSteps() {
        numberOfSteps = PRECISION;
    }

    public int getNumberOfVariables(){
        return numberOfVariables;
    }

    public int getMaximumDepth() {
        return MAXIMUM_DEPTH;
    }

    public double getStepLength() {
        return stepLength;
    }

    public double getNumberOfSteps() {
        return numberOfSteps;
    }
}
