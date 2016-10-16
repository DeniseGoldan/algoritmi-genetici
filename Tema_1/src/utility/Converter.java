package utility;

import java.util.ArrayList;
import java.util.List;

/**
 * The converter uses the Big Endian rule.
 * The most significant bit is on index 0.
 * Created by Denise Goldan on 10/15/2016.
 */
public class Converter {
    public static int getIntegerFromBitsArray(BitsArray representationInBits) {
        int resultedInteger = 0;
        int numberOfBits = representationInBits.getNumberOfBits();
        for (int i = 0; i < numberOfBits; i++) {
            if (representationInBits.getBit(i)) {
                resultedInteger += Math.pow(2, numberOfBits - i - 1);
            }
        }
        return resultedInteger;
    }

    public static List<Integer> getIntegerListFromBitsArrayList(List<BitsArray> representationsInBits) {
        List<Integer> integerList = new ArrayList<>(representationsInBits.size());
        for (int i = 0; i < representationsInBits.size(); i++) {
            integerList.add(getIntegerFromBitsArray(representationsInBits.get(i)));
        }
        return integerList;
    }

    public static List<Double> getDoubleListFromIntegerList(List<Integer> integerList, ClosedInterval domain, int numberOfBits) {
        List<Double> doubleList = new ArrayList<>(integerList.size());
        for (Integer current : integerList) {
            doubleList.add(domain.getFirstEndpoint() + (current * (domain.getSecondEndpoint() - domain.getFirstEndpoint()) / (Math.pow(2, numberOfBits) - 1)));
        }
        return doubleList;
    }
}
