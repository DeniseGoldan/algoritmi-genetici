package utility;

import oracle.jrockit.jfr.events.Bits;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Denise Goldan on 10/15/2016.
 */
public class RandomGenerator {

    public static List<BitsArray> getRandomBitsArrayList(int numberOfVariables, int numberOfBits) {
        if (numberOfVariables <= 0) {
            throw new AssertionError("The number of variables can not be smaller than 1.");
        }
        ThreadLocalRandom random = ThreadLocalRandom.current();
        List<BitsArray> variables = new ArrayList<>();
        for (int i = 0; i < numberOfVariables; i++) {
            BitsArray representationInBits = new BitsArray(numberOfBits);
            for (int j = 0; j < numberOfBits; j++) {
                representationInBits.setBit(j, random.nextBoolean());
            }
            variables.add(representationInBits);
        }
        return variables;
    }


}
