package functions;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by Denise Goldan on 10/9/2016.
 */
public class SixHumpCamelBackTest {

    @Test
    public void getFunctionName(){
        SixHumpCamelBack function = new SixHumpCamelBack();
        String expectedReturn = "Six Hump Camel Back function";
        assertTrue(expectedReturn.equals(function.getFunctionName()));
    }

}