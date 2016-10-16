package utility;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Denise Goldan on 10/15/2016.
 */
public class RandomGeneratorTest {
    @Test
    public void getRandomBitsArrayList_returnsAListOfBitsArrayWhenNumberOfVariablesIsPositive() {
        List<BitsArray> variables = RandomGenerator.getRandomBitsArrayList(3,4);
        for (int i = 0; i<3; i++){
            for (int j = 0; j<4; j++){
                System.out.print(variables.get(i).getBit(j)+" ");
            }
            System.out.println();
        }
    }
}