import utility.ClosedInterval;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
        ClosedInterval interval = new ClosedInterval();
        interval.setSecondEndpoint(10);
        interval.setFirstEndpoint(9);
        assertThat((int)interval.getFirstEndpoint(),is(9));
    }

    @Test
    public void setSecondEndpoint_setsSecondEndpointWhenArgumentIsBiggerThanFirstEndpoint(){
        ClosedInterval interval = new ClosedInterval();
        interval.setFirstEndpoint(-3);
        interval.setSecondEndpoint(10);
        assertThat((int)interval.getSecondEndpoint(),is(10));
    }

    @Test (expected = java.lang.AssertionError.class)
    public void setFirstEndpoint_throwsExceptionWhenProvidedWithIncorrectArgument() throws Exception{
        ClosedInterval interval = new ClosedInterval();
        interval.setSecondEndpoint(10);
        interval.setFirstEndpoint(20);
        assertThat((int)interval.getFirstEndpoint(),is(20));
    }

    @Test (expected = java.lang.AssertionError.class)
    public void setSecondEndpoint_throwsExceptionWhenProvidedWithIncorrectArgument() throws Exception{
        ClosedInterval interval = new ClosedInterval();
        interval.setFirstEndpoint(20);
        interval.setSecondEndpoint(10);
        assertThat((int)interval.getSecondEndpoint(),is(10));
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
