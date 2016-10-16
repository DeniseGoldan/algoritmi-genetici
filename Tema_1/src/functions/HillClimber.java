package functions;

import utility.BitsArray;
import utility.Converter;
import utility.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static functions.NeighbourGenerator.getNeighbourAtHammingDistanceOfOne;

/**
 * Created by Denise Goldan on 10/15/2016.
 */
public class HillClimber {
    public static final int NUMBER_OF_ITERATIONS = 1000;
    public static final int NUMBER_OF_NEIGHBOURS = 30;
    FunctionInvokerConfiguration configuration;

    public static void main(String[] args) {
        Function deJong = new DeJong();
        Function ackley = new Ackley();
        Function schwefel = new Schwefel();
        Function six = new SixHumpCamelBack();
        HillClimber climber = new HillClimber();
        climber.runHillClimbing(deJong, 4, 5);
        climber.runHillClimbing(ackley, 4, 6);
        climber.runHillClimbing(schwefel, 4, 6);
        climber.runHillClimbing(six, 2, 5);
    }

    private void runHillClimbing(Function function, int desiredNumberOfVariables, int desiredPrecision) {
        configuration = new FunctionInvokerConfiguration();
        configuration.configureSearch(function, desiredNumberOfVariables, desiredPrecision);

        double bestResult = Double.MAX_VALUE;
        List<BitsArray> bestVariablesInBits = new ArrayList<>();

        double candidateResult;
        List<BitsArray> candidateVariablesInBits;

        double neighbourResult;
        List<BitsArray> neighbourVariablesInBits = new ArrayList<>();

        boolean local;
        int counter = 0;
        do {
            local = false;
            // select a candidate at random and evaluate it
            candidateVariablesInBits = RandomGenerator.getRandomBitsArrayList(desiredNumberOfVariables, configuration.getNumberOfBits());
            candidateResult = function.getCalculationResult(Converter.getDoubleListFromIntegerList(Converter.getIntegerListFromBitsArrayList(candidateVariablesInBits), function.getVariablesDomain().get(0), configuration.getNumberOfBits()));
            do {
                // pick the best neighbour out of a number of NUMBER_OF_NEIGHBOURS neighbours
                for (int i = 0; i <= NUMBER_OF_NEIGHBOURS; i++) {
                    neighbourVariablesInBits = getNeighbourAtHammingDistanceOfOne(candidateVariablesInBits, configuration);
                    neighbourResult = function.getCalculationResult(Converter.getDoubleListFromIntegerList(Converter.getIntegerListFromBitsArrayList(neighbourVariablesInBits), function.getVariablesDomain().get(0), configuration.getNumberOfBits()));
                    if (candidateResult > neighbourResult) {
                        candidateResult = neighbourResult;
                        candidateVariablesInBits.clear();
                        candidateVariablesInBits.addAll(neighbourVariablesInBits);
                    }
                }
                // if the best neighbour I found is actually better than my current candidate
                neighbourResult = function.getCalculationResult(Converter.getDoubleListFromIntegerList(Converter.getIntegerListFromBitsArrayList(neighbourVariablesInBits), function.getVariablesDomain().get(0), configuration.getNumberOfBits()));
                if (candidateResult > neighbourResult) {
                    candidateResult = neighbourResult;
                    candidateVariablesInBits.clear();
                    candidateVariablesInBits.addAll(neighbourVariablesInBits);
                } else {
                    local = true;
                }
            } while (!local);
            counter++;
            if (candidateResult < bestResult) {
                bestResult = candidateResult;
                bestVariablesInBits.clear();
                bestVariablesInBits.addAll(candidateVariablesInBits);
            }
        }
        while (counter < NUMBER_OF_ITERATIONS);
        System.out.println(function.getFunctionName() + " : " + bestResult);
    }

}
