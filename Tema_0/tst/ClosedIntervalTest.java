import org.junit.Test;
import utility.ClosedInterval;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Denise Goldan on 10/6/2016.
 */
public class ClosedIntervalTest {
    @Test
    public void getFirstEndpoint_returnsFirstEndpointVariable(){
        ClosedInterval interval = new ClosedInterval(10,12);
        assertThat(((int) interval.getFirstEndpoint()), is(10));
    }

    @Test
    public void getSecondEndpoint_returnsFirstEndpointVariable(){
        ClosedInterval interval = new ClosedInterval(10,12);
        assertThat((int) interval.getSecondEndpoint(), is(12));
    }

    @Test
    public void setFirstEndpoint_setsFirstEndpointWhenWhenArgumentIsSmallerThanSecondEndpoint(){
        ClosedInterval interval = new ClosedInterval(10,12);
        interval.setFirstEndpoint(9);
        assertThat((int)interval.getFirstEndpoint(),is(9));
    }

    @Test
    public void setSecondEndpoint_setsSecondEndpointWhenArgumentIsBiggerThanFirstEndpoint(){
        ClosedInterval interval = new ClosedInterval(-3.6,39);
        interval.setSecondEndpoint(10);
        assertThat((int)interval.getSecondEndpoint(),is(10));
    }

    @Test (expected = java.lang.AssertionError.class)
    public void setFirstEndpoint_throwsExceptionWhenProvidedWithIncorrectArgument() throws Exception{
        ClosedInterval interval = new ClosedInterval(11,21.3);
        interval.setFirstEndpoint(120);
        assertThat((int)interval.getFirstEndpoint(),is(120));
    }

    @Test (expected = java.lang.AssertionError.class)
    public void setSecondEndpoint_throwsExceptionWhenProvidedWithIncorrectArgument() throws Exception{
        ClosedInterval interval = new ClosedInterval(4,33);
        interval.setSecondEndpoint(0);
        assertThat((int)interval.getSecondEndpoint(),is(0));
    }

    @Test
    public void ClosedIntervalConstructorWithTwoParameters_setsValuesForVariablesWhenFirstArgumentIsSmallerThanSecondArgument()
            throws Exception{
        ClosedInterval interval = new ClosedInterval(-10,29);
        assertThat((int)interval.getFirstEndpoint(),is(-10));
        assertThat((int)interval.getSecondEndpoint(),is(29));
    }

    @Test (expected = java.lang.AssertionError.class)
    public void ClosedIntervalConstructorWithTwoParameters_throwsExceptionWhenFirstArgumentIsBiggerThanSecondArgument()
            throws Exception{
       ClosedInterval interval = new ClosedInterval(10,-21.4);
    }
}
