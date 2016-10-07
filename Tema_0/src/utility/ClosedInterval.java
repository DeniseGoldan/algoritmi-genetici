package utility;

/**
 * Created by Denise Goldan on 10/6/2016.
 */
public class ClosedInterval {
    private double firstEndpoint;
    private double secondEndpoint;

    public ClosedInterval(double desiredFirstEndpoint, double desiredSecondEndpoint) {
        if (desiredFirstEndpoint >= desiredSecondEndpoint) {
            throw new AssertionError();
        }
        firstEndpoint = desiredFirstEndpoint;
        secondEndpoint = desiredSecondEndpoint;
    }

    public ClosedInterval() {

    }

    public double getFirstEndpoint() {
        return firstEndpoint;
    }

    public void setFirstEndpoint(double desiredFirstEndpoint) {
        if (desiredFirstEndpoint >= secondEndpoint) {
            throw new AssertionError();
        }
        firstEndpoint = desiredFirstEndpoint;
    }

    public double getSecondEndpoint() {
        return secondEndpoint;
    }

    public void setSecondEndpoint(double desiredSecondEndpoint) {
        if (firstEndpoint >= desiredSecondEndpoint) {
            throw new AssertionError();
        }
        secondEndpoint = desiredSecondEndpoint;
    }

}
