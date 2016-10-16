package functions;

import utility.ClosedInterval;

import java.util.Collections;
import java.util.List;

/**
 * Created by Denise Goldan on 10/6/2016.
 */
public class DeJong implements Function {

    private static final double DOMAIN_FIRST_ENDPOINT = -5.12;
    private static final double DOMAIN_SECOND_ENDPOINT = 5.12;

    @Override
    public double getCalculationResult(List<Double> variables) {

        if (0 == variables.size()) {
            throw new AssertionError("The number of variables must be greater than 0.");
        }

        double result = 0;
        for (int i = 0; i < variables.size(); i++) {
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
        return Collections.singletonList(new ClosedInterval(DOMAIN_FIRST_ENDPOINT, DOMAIN_SECOND_ENDPOINT));
    }

}
