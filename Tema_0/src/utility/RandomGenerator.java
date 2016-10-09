package utility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Denise Goldan on 10/7/2016.
 */
public class RandomGenerator {
    public static List<Double> getRandomVariableValueList(int numberOfVariables, List<ClosedInterval> variablesDomain) {
        if (numberOfVariables != variablesDomain.size() && variablesDomain.size() > 1) {
            throw new AssertionError("If the variables have different domains, there should be a 1 to 1 correspondence.");
        }

        List<Double> variables = new ArrayList<>();

        for (int i = 0; i < numberOfVariables; i++) {
            if (1 == variablesDomain.size()) {
                variables.add(RandomGenerator.getRandomValue(variablesDomain.get(0)));
            } else {
                variables.add(RandomGenerator.getRandomValue(variablesDomain.get(i)));
            }
        }
        return variables;
    }

    public static double getRandomValue(ClosedInterval domain) {
        return ThreadLocalRandom.current().nextDouble(domain.getFirstEndpoint(), domain.getSecondEndpoint());
    }
}
