package utility;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Denise Goldan on 10/15/2016.
 */
public class BitsArrayTest {
    @Test
    public void negateBit_negatesBitAtDesiredIndexWhenProvidedWithIndexInsideBounds() throws Exception {
        BitsArray number = new BitsArray(2);
        number.setBit(0, true);
        number.negateBit(0);
        assertThat(number.getBit(0), is(false));
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void negateBit_throwsExceptionWhenProvidedWithIndexOutOfBounds() throws Exception {
        BitsArray number = new BitsArray(1);
        number.setBit(0, true);
        number.negateBit(1);
    }

    @Test
    public void setBit_setsBitAtDesiredIndexWhenProvidedWithIndexInsideBounds() throws Exception {
        BitsArray number = new BitsArray(3);
        number.setBit(0, true);
        number.setBit(1, true);
        assertThat(number.getBit(0), is(true));
        assertThat(number.getBit(1), is(true));
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void setBit_throwsExceptionWhenProvidedWithIndexOutOfBounds() throws Exception {
        BitsArray number = new BitsArray(3);
        number.setBit(3, true);
    }

    @Test
    public void getNumberOfBits_returnsNumberOfBitsSettedInTheConstructor() {
        BitsArray number = new BitsArray(10);
        assertThat(number.getNumberOfBits(), is(10));
    }

    @Test
    public void setNumberOfBits_setsNumberOfBitsWhenProvidedWithPositiveArgument() throws Exception {
        BitsArray number = new BitsArray(10);
        number.setNumberOfBits(29);
        assertThat(number.getNumberOfBits(), is(29));
    }

    @Test(expected = java.lang.AssertionError.class)
    public void setNumberOfBits_throwsExceptionWhenProvidedWithNegativeArgument() throws Exception {
        BitsArray number = new BitsArray(10);
        number.setNumberOfBits(-3);
        assertThat(number.getNumberOfBits(), is(-3));
    }

    @Test
    public void getBit_returnsBitAtDesiredIndexWhenProvidedWithIndexInsideBounds() throws Exception {
        BitsArray number = new BitsArray(3);
        number.setBit(0, true);
        number.setBit(1, false);
        assertThat(number.getBit(1), is(false));
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void getBit_throwsExceptionWhenProvidedWithIndexOutOfBounds() throws Exception {
        BitsArray number = new BitsArray(3);
        number.getBit(8);
    }

    @Test
    public void BitsArray_WithBitsArrayParameterDeepCopiesTheArgument(){
        BitsArray original = new BitsArray(3);
        original.setBit(0, true);
        original.setBit(1, true);
        BitsArray deepCopy = new BitsArray(original);
        assertThat(deepCopy.getBit(0), is(true));
        assertThat(deepCopy.getBit(1), is(true));
        original.setBit(0, false);
        original.setBit(1, false);
        assertThat(original.getBit(0), is(false));
        assertThat(original.getBit(1), is(false));
        assertThat(deepCopy.getBit(0), is(true));
        assertThat(deepCopy.getBit(1), is(true));
    }
}