package functions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;;

/**
 * Created by Denise Goldan on 10/9/2016.
 */
public class MinimumFinderTest {

    @Test
    public void calculateStepLength_returns0IfCurrentDepthIs0(){
        MinimumFinder scout = new MinimumFinder();
        assertThat(scout.calculateStepLength(0), is(0.0));
    }

    @Test
    public void calculateStepLength_returnsCorrespondingStepLengthIfCurrentDepthIs2(){
        MinimumFinder scout = new MinimumFinder();
        Ackley function = new Ackley();
        scout.configureSearch(function,2);
        assertThat(scout.calculateStepLength(2), is(scout.getConfiguration().getStepLength()*0.75*0.75));
    }
}