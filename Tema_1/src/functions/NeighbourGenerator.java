package functions;

import utility.BitsArray;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Denise Goldan on 10/16/2016.
 */
public class NeighbourGenerator {

    public static List<BitsArray> getNeighbourAtHammingDistanceOfOne(List<BitsArray> candidateVariablesInBits, FunctionInvokerConfiguration configuration) {

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomVariableIndex = random.nextInt(0, configuration.getNumberOfVariables());
        int randomBitIndex = random.nextInt(0, configuration.getNumberOfBits());

        List<BitsArray> neighbour = new ArrayList<>();
        neighbour.addAll(candidateVariablesInBits);

        BitsArray changedVariable = new BitsArray(candidateVariablesInBits.get(randomVariableIndex));
        changedVariable.negateBit(randomBitIndex);
        neighbour.set(randomVariableIndex, changedVariable);

        return neighbour;
    }
}
