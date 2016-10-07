package functions;

import utility.ClosedInterval;

import java.util.List;

/**
 * Created by Denise Goldan on 10/6/2016.
 */
public class SixHumpCamelBack implements Function {
    private static final double DOMAIN_FIRST_ENDPOINT_FOR_FIRST_VARIABLE = -3;
    private static final double DOMAIN_SECOND_ENDPOINT_FOR_FIRST_VARIABLE = 3;
    private static final double DOMAIN_FIRST_ENDPOINT_FOR_SECOND_VARIABLE = -2;
    private static final double DOMAIN_SECOND_ENDPOINT_FOR_SECOND_VARIABLE = 2;
    private int numberOfVariables;

    @Override
    public Function withNumberOfVariables(int desiredNumberOfVariables) {
        if (2 != numberOfVariables) {
            throw new RuntimeException(getFunctionName() + " has only 2 variables. The desiredNumberOfVariables can only be eqal to 2. ");
        }
        return this;
    }

    @Override
    public int getNumberOfVariables() {
        return numberOfVariables;
    }

    @Override
    public double getCalculationResult(List<Double> variables) {

        if (2 != variables.size()) {
            throw new AssertionError();
        }

        double x1 = variables.get(0);
        double x2 = variables.get(1);

        return (4 - 2.1 * Math.pow(x1, 2) + Math.pow(x1, 4 / 3)) * Math.pow(x1, 2)
                + x1 * x2 + (-4 + 4 * Math.pow(x2, 2)) * Math.pow(x2, 2);
    }

    @Override
    public String getFunctionName() {
        return "SixHumpCamelBack function";
    }

    @Override
    public List<ClosedInterval> getVariablesDomain() {
        List<ClosedInterval> domain = null;
        ClosedInterval interval = new ClosedInterval(DOMAIN_FIRST_ENDPOINT_FOR_FIRST_VARIABLE, DOMAIN_SECOND_ENDPOINT_FOR_FIRST_VARIABLE);
        domain.add(interval);
        interval = new ClosedInterval(DOMAIN_FIRST_ENDPOINT_FOR_SECOND_VARIABLE, DOMAIN_SECOND_ENDPOINT_FOR_SECOND_VARIABLE);
        domain.add(interval);
        return domain;
    }
}
