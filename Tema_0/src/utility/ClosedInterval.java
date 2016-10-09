package utility;

/**
 * Created by Denise Goldan on 10/6/2016.
 */
public class ClosedInterval {
    private double firstEndpoint;
    private double secondEndpoint;

    public ClosedInterval(double desiredFirstEndpoint, double desiredSecondEndpoint) {
        if (desiredFirstEndpoint >= desiredSecondEndpoint) {
            throw new AssertionError("The desired first endpoint is greater or equal to the desired second endpoint.");
        }
        firstEndpoint = desiredFirstEndpoint;
        secondEndpoint = desiredSecondEndpoint;
    }

    public double getFirstEndpoint() {
        return firstEndpoint;
    }

    public void setFirstEndpoint(double desiredFirstEndpoint) {
        if (desiredFirstEndpoint >= secondEndpoint) {
            throw new AssertionError("The desired first endpoint is greater or equal to the second endpoint.");
        }
        firstEndpoint = desiredFirstEndpoint;
    }

    public double getSecondEndpoint() {
        return secondEndpoint;
    }

    public void setSecondEndpoint(double desiredSecondEndpoint) {
        if (firstEndpoint >= desiredSecondEndpoint) {
            throw new AssertionError("The first endpoint is greater or equal to the desired second endpoint.");
        }
        secondEndpoint = desiredSecondEndpoint;
    }

    public static boolean isInsideClosedInterval(double value, ClosedInterval interval){
        if (value < interval.getFirstEndpoint() || value > interval.getSecondEndpoint()){
            return false;
        }
        return true;
    }

}
