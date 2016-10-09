package functions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Denise Goldan on 10/9/2016.
 */
public class SixHumpCamelBackTest {
    @Test
    public void getFunctionName(){
        SixHumpCamelBack function = new SixHumpCamelBack();
        String expectedReturn = "SixHumpCamelBack function";
        assertTrue(expectedReturn.equals(function.getFunctionName()));
    }
}