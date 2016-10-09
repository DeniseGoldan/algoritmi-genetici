package functions;

import utility.ClosedInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denise Goldan on 10/6/2016.
 */
public class Ackley implements Function {
    private static final double DOMAIN_FIRST_ENDPOINT = -1;
    private static final double DOMAIN_SECOND_ENDPOINT = 1;

    @Override
    public double getCalculationResult(List<Double> variables) {

        if (0 == variables.size()) {
            throw new AssertionError("The number of variables must be greater than 0.");
        }

        double firstSum = 0;
        double secondSum = 0;
        double value = 2 * Math.PI;

        for (int i = 0; i < variables.size(); i++) {
            double current = variables.get(i);
            firstSum += Math.pow(current, 2);
            secondSum += Math.cos(Math.toRadians(value * current));
        }

        firstSum /= variables.size();
        secondSum = Math.ceil(secondSum);
        secondSum /= variables.size();

        return (-20 * Math.exp(-0.2 * Math.sqrt(firstSum)) + 20 + Math.exp(1) - Math.exp(secondSum));
    }

    @Override
    public String getFunctionName() {
        return "Ackley's Path function";
    }

    @Override
    public List<ClosedInterval> getVariablesDomain() {
        List<ClosedInterval> domain = new ArrayList<>();
        ClosedInterval interval = new ClosedInterval(DOMAIN_FIRST_ENDPOINT, DOMAIN_SECOND_ENDPOINT);
        domain.add(interval);
        return domain;
    }
}
