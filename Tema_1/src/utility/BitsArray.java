package utility;

/**
 * Created by Denise Goldan on 10/15/2016.
 */
public class BitsArray {

    private boolean[] bitsArray;
    private int numberOfBits;

    public BitsArray(BitsArray original){
        numberOfBits = original.getNumberOfBits();
        bitsArray = original.bitsArray.clone();
    }

    public BitsArray(int desiredNumberOfBits) {
        if (desiredNumberOfBits <= 0) {
            throw new AssertionError("The length of the array can not be smaller than 1.");
        }
        bitsArray = new boolean[desiredNumberOfBits];
        numberOfBits = desiredNumberOfBits;
    }

    public int getNumberOfBits() {
        return numberOfBits;
    }

    void setNumberOfBits(int desiredNumberOfBits) {
        if (desiredNumberOfBits <= 0) {
            throw new AssertionError("The length of the array can not be smaller than 1.");
        }
        bitsArray = new boolean[desiredNumberOfBits];
        numberOfBits = desiredNumberOfBits;
    }

    public boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex >= numberOfBits) {
            throw new RuntimeException("The index is out of bounds.");
        }
        return bitsArray[bitIndex];
    }

    public void setBit(int bitIndex, boolean desiredValue) {
        if (bitIndex < 0 || bitIndex >= numberOfBits) {
            throw new RuntimeException("The index is out of bounds.");
        }
        bitsArray[bitIndex] = desiredValue;
    }

    public void negateBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex >= numberOfBits) {
            throw new RuntimeException("The index is out of bounds.");
        }
        bitsArray[bitIndex] = !bitsArray[bitIndex];
    }
}