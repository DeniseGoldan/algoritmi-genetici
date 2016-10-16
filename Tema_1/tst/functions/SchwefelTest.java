package functions;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by Denise Goldan on 10/9/2016.
 */
public class SchwefelTest {

    @Test
    public void getFunctionName(){
        Schwefel function = new Schwefel();
        String expectedReturn = "Schwefel's function";
        assertTrue(expectedReturn.equals(function.getFunctionName()));
    }
}