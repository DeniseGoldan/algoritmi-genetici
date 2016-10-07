package functions;

import utility.ClosedInterval;

import java.util.List;

/**
 * Created by Denise Goldan on 10/6/2016.
 */
public class Ackley implements Function {
    private static final double DOMAIN_FIRST_ENDPOINT = -32.768;
    private static final double DOMAIN_SECOND_ENDPOINT = 32.768;
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

        double firstSum = 0;
        double secondSum = 0;
        double value = 2 * Math.PI;

        for (int i = 1; i <= variables.size(); i++) {

            double current = variables.get(i);
            firstSum += Math.pow(current, 2);
            secondSum += Math.cos(value * current);
        }

        firstSum *= 1 / numberOfVariables;
        secondSum *= 1 / numberOfVariables;

        return (-20 * Math.exp(-0.2 * Math.sqrt(firstSum)) -
                Math.exp(secondSum) + 20 + Math.exp(1));
    }

    @Override
    public String getFunctionName() {
        return "Ackley's function";
    }

    @Override
    public List<ClosedInterval> getVariablesDomain() {
        ClosedInterval interval = new ClosedInterval(DOMAIN_FIRST_ENDPOINT, DOMAIN_SECOND_ENDPOINT);
        List<ClosedInterval> domain = null;
        domain.add(interval);
        return domain;
    }
}
