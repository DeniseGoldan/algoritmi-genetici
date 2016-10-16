package functions;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by Denise Goldan on 10/9/2016.
 */
public class AckleyTest {

    @Test
    public void getFunctionName(){
        Ackley function = new Ackley();
        String expectedReturn = "Ackley's Path function";
        assertTrue(expectedReturn.equals(function.getFunctionName()));
    }
}