package functions;

import utility.BitsArray;
import utility.Converter;
import utility.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static functions.NeighbourGenerator.getNeighbourAtHammingDistanceOfOne;

/**
 * Created by Denise Goldan on 10/16/2016.
 */
public class SimulatedAnnealing {

    public static final int NUMBER_OF_NEIGHBOURS = 100;
    FunctionInvokerConfiguration configuration;

    public static void main(String[] args) {
        Function deJong = new DeJong();
        Function ackley = new Ackley();
        Function schwefel = new Schwefel();
        Function six = new SixHumpCamelBack();
        SimulatedAnnealing smith = new SimulatedAnnealing();
        smith.runSimulatedAnnealing(deJong, 4, 5);
        smith.runSimulatedAnnealing(ackley, 4, 6);
        smith.runSimulatedAnnealing(schwefel, 4, 6);
        smith.runSimulatedAnnealing(six, 2, 5);
    }

    private void runSimulatedAnnealing(Function function, int desiredNumberOfVariables, int desiredPrecision) {
        configuration = new FunctionInvokerConfiguration();
        configuration.configureSearch(function, desiredNumberOfVariables, desiredPrecision);

        double candidateResult;
        List<BitsArray> candidateVariablesInBits;

        double neighbourResult;
        List<BitsArray> neighbourVariablesInBits = new ArrayList<>();

        double temperature = 1_000;
        double coolingRate = 0.05;
        double minimumTemperature = 0.0_001;
        // select a candidate at random and evaluate it
        candidateVariablesInBits = RandomGenerator.getRandomBitsArrayList(desiredNumberOfVariables, configuration.getNumberOfBits());
        candidateResult = function.getCalculationResult(Converter.getDoubleListFromIntegerList(Converter.getIntegerListFromBitsArrayList(candidateVariablesInBits), function.getVariablesDomain().get(0), configuration.getNumberOfBits()));

        do {
            for (int i = 0; i < NUMBER_OF_NEIGHBOURS; i++) {
                neighbourVariablesInBits = getNeighbourAtHammingDistanceOfOne(candidateVariablesInBits, configuration);
                neighbourResult = function.getCalculationResult(Converter.getDoubleListFromIntegerList(Converter.getIntegerListFromBitsArrayList(neighbourVariablesInBits), function.getVariablesDomain().get(0), configuration.getNumberOfBits()));
                if (candidateResult > neighbourResult) {
                    candidateResult = neighbourResult;
                    candidateVariablesInBits.clear();
                    candidateVariablesInBits.addAll(neighbourVariablesInBits);
                } else {
                    ThreadLocalRandom random = ThreadLocalRandom.current();
                    if (random.nextDouble(0, 1) < Math.exp(-Math.abs((neighbourResult - candidateResult)) / temperature)) {
                        candidateResult = neighbourResult;
                        candidateVariablesInBits.clear();
                        candidateVariablesInBits.addAll(neighbourVariablesInBits);
                    }
                }
            }
            temperature *= coolingRate;
        } while (temperature > minimumTemperature);
        System.out.println(function.getFunctionName() + " : " + candidateResult);
    }

}

