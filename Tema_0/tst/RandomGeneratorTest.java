import org.junit.Test;
import utility.ClosedInterval;
import utility.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denise Goldan on 10/7/2016.
 */
public class RandomGeneratorTest {

    @Test
    public void getRandomValue_returnsAValueInsideTheDomain() {
        ClosedInterval domain = new ClosedInterval(-1.003, 1.003);
        for (int i = 0; i < 100; i++) {
            double randomNumber = RandomGenerator.getRandomValue(domain);
            if (domain.getFirstEndpoint() >= randomNumber || domain.getSecondEndpoint() <= randomNumber) {
                throw new RuntimeException("The provided number is not inside the domain.");
            }
        }
    }

    @Test
    public void getRandomVariableValueList_returnsAListOfNumbersWithinTheSpecifiedDomain(){
        List<ClosedInterval> domain = new ArrayList<>();
        ClosedInterval interval = new ClosedInterval(-10,10);
        domain.add(interval);
        List<Double> list = RandomGenerator.getRandomVariableValueList(150, domain);
        for (int i = 0; i<150; i++){
            if (!ClosedInterval.isInsideClosedInterval(list.get(i),interval)) {
                throw new RuntimeException("getRandomVariableValueList provided a value that is not inside the domain.");
            }
        }

    }
}
