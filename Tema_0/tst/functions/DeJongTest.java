package functions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Denise Goldan on 10/9/2016.
 */
public class DeJongTest {
    @Test
    public void getFunctionName(){
        DeJong function = new DeJong();
        String expectedReturn = "De Jong's function";
        assertTrue(expectedReturn.equals(function.getFunctionName()));
    }
}