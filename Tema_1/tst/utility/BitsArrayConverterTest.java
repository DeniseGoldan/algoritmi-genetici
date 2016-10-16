package utility;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Denise Goldan on 10/15/2016.
 */
public class BitsArrayConverterTest {
    @Test
    public void getIntegerListFromBitsArrayList() throws Exception {
        BitsArray firstRepresentation = new BitsArray(4);
        firstRepresentation.setBit(0,true);
        firstRepresentation.setBit(1,true);
        firstRepresentation.setBit(2,true);
        firstRepresentation.setBit(3,true);
        BitsArray secondRepresentation = new BitsArray(4);
        secondRepresentation.setBit(0,false);
        secondRepresentation.setBit(1,false);
        secondRepresentation.setBit(2,false);
        secondRepresentation.setBit(3,true);
        List<BitsArray> bitsList = new ArrayList<>();
        bitsList.add(firstRepresentation);
        bitsList.add(secondRepresentation);
        List<Integer> expectedIntegersList = new ArrayList();
        expectedIntegersList.add(15);
        expectedIntegersList.add(1);
        assertThat(Converter.getIntegerListFromBitsArrayList(bitsList), is (expectedIntegersList));

    }

    @Test
    public void getIntegerFromBitsArray_returnsTheResultedIntegerWhenProvidedWithABitsArray() {
        BitsArray representationInBits = new BitsArray(4);
        representationInBits.setBit(0,true);
        representationInBits.setBit(1,true);
        representationInBits.setBit(2,true);
        representationInBits.setBit(3,true);
        assertThat(Converter.getIntegerFromBitsArray(representationInBits), is (15));
    }
}