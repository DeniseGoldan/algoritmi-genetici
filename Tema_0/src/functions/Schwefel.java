package functions;

import utility.ClosedInterval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Denise Goldan on 10/6/2016.
 */
public class Schwefel implements Function {
    private static final double DOMAIN_FIRST_ENDPOINT = -500;
    private static final double DOMAIN_SECOND_ENDPOINT = 500;

    @Override
    public double getCalculationResult(List<Double> variables) {
        if (0 == variables.size()) {
            throw new AssertionError("The number of variables must be greater than 0.");
        }
        double result = 0;
        for (int i = 0; i < variables.size(); i++) {
            double current = variables.get(i);
            result += -current *
                    Math.sin(
                            Math.sqrt(
                                    Math.abs(current)));
        }
        return result;
    }

    @Override
    public String getFunctionName() {
        return "Schwefel's function";
    }

    @Override
    public List<ClosedInterval> getVariablesDomain() {
        List<ClosedInterval> domain = new ArrayList<>();
        ClosedInterval interval = new ClosedInterval(DOMAIN_FIRST_ENDPOINT, DOMAIN_SECOND_ENDPOINT);
        domain.add(interval);
        return domain;
    }
}
