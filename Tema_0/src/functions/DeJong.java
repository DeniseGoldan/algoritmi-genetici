package functions;

import utility.ClosedInterval;

import java.util.List;

/**
 * Created by Denise Goldan on 10/6/2016.
 */
public class DeJong implements Function {

    private static final double DOMAIN_FIRST_ENDPOINT = -5.12;
    private static final double DOMAIN_SECOND_ENDPOINT = 5.12;
    private int numberOfVariables;

    @Override
    public Function withNumberOfVariables(int desiredNumberOfVariables) {
        numberOfVariables = desiredNumberOfVariables;
        return this;
    }

    @Override
    public int getNumberOfVariables() {
        return numberOfVariables;
    }

    @Override
    public double getCalculationResult(List<Double> variables) {
        double result = 0;
        for (int i = 1; i <= variables.size(); i++) {
            result += Math.pow(variables.get(i), 2);
        }
        return result;
    }

    @Override
    public String getFunctionName() {
        return "De Jong's function";
    }

    @Override
    public List<ClosedInterval> getVariablesDomain() {
        ClosedInterval interval = new ClosedInterval(DOMAIN_FIRST_ENDPOINT, DOMAIN_SECOND_ENDPOINT);
        List<ClosedInterval> domain = null;
        domain.add(interval);
        return domain;
    }

}
