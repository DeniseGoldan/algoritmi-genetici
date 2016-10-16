package functions;

/**
 * http://profs.info.uaic.ro/~pmihaela/GA/laborator2.html
 * The precision is referred to as Math.pow(10, -d).
 * I consider the precision to be that "d".
 * Created by Denise Goldan on 10/15/2016.
 */
public class FunctionInvokerConfiguration {
    private int precision;
    private int numberOfVariables;
    private int numberOfBits;
    private Function targetedFunction;

    public void configureSearch(Function function, int desiredNumberOfVariables, int desiredPrecision) {
        setNumberOfVariables(function, desiredNumberOfVariables);
        setTargetedFunction(function);
        setPrecision(desiredPrecision);
        setNumberOfBits();
    }

    public void setNumberOfBits() {
        int numberOfSubintervals = (int) (targetedFunction.getVariablesDomain().get(0).getSecondEndpoint() -
                targetedFunction.getVariablesDomain().get(0).getFirstEndpoint()) * (int) Math.pow(10, precision);
        numberOfBits = (int) Math.ceil(Math.log(numberOfSubintervals));
    }

    public void setTargetedFunction(Function desiredFunction) {
        targetedFunction = desiredFunction;
    }

    public void setPrecision(int desiredPrecision) {
        precision = desiredPrecision;
    }

    private void setNumberOfVariables(Function function, int desiredNumberOfVariables) {
        if (desiredNumberOfVariables <= 0) {
            throw new AssertionError("The number of variables must be greater than 0.");
        }
        if (function.getFunctionName().equals("Six Hump Camel Back function") && desiredNumberOfVariables != 2) {
            throw new RuntimeException(function.getFunctionName() + " has only 2 variables. The desiredNumberOfVariables can only be equal to 2. " + desiredNumberOfVariables + " = the given number.");
        }
        numberOfVariables = desiredNumberOfVariables;
    }

    public int getNumberOfVariables() {
        return numberOfVariables;
    }

    public int getNumberOfBits() {
        return numberOfBits;
    }
}