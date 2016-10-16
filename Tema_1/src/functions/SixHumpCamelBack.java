package functions;

import utility.ClosedInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denise Goldan on 10/6/2016.
 * <p>
 * http://www.geatbx.com/docu/fcnindex-01.html#P247_13252
 * The function's global minimum is f(x1,x2)=-1.0316; (x1,x2)=(-0.0898,0.7126), (0.0898,-0.7126).
 * There are 2 versions of the function provided to us on the page.
 * The first definition is:
 * f(x1,x2)=(4-2.1·x1^2+x1^ (4/3) )·x1^2+x1·x2+(-4+4·x2^2)·x2^2, -3<=x1<=3, -2<=x2<=2.
 * The second definition is:
 * f(x1,x2)=(4-2.1·x1^2+x1^4  / 3 )·x1^2+x1·x2+(-4+4·x2^2)·x2^2, -3<=x1<=3, -2<=x2<=2.
 * The function's global minimum is f(x1,x2)=-1.0316; (x1,x2)=(-0.0898,0.7126), (0.0898,-0.7126),
 * if you choose the second definition.
 */
public class SixHumpCamelBack implements Function {
    private static final double DOMAIN_FIRST_ENDPOINT_FOR_FIRST_VARIABLE = -3;
    private static final double DOMAIN_SECOND_ENDPOINT_FOR_FIRST_VARIABLE = 3;
    private static final double DOMAIN_FIRST_ENDPOINT_FOR_SECOND_VARIABLE = -2;
    private static final double DOMAIN_SECOND_ENDPOINT_FOR_SECOND_VARIABLE = 2;

    @Override
    public double getCalculationResult(List<Double> variables) {

        if (2 != variables.size()) {
            throw new AssertionError(getFunctionName() + "has only 2 variables.");
        }

        double x1 = variables.get(0);
        double x2 = variables.get(1);

        return (4 - 2.1 * Math.pow(x1, 2) + Math.pow(x1, 4) / 3) * Math.pow(x1, 2)
                + x1 * x2 + (-4 + 4 * Math.pow(x2, 2)) * Math.pow(x2, 2);
    }

    @Override
    public String getFunctionName() {
        return "Six Hump Camel Back function";
    }

    @Override
    public List<ClosedInterval> getVariablesDomain() {
        List<ClosedInterval> domain = new ArrayList<>();
        ClosedInterval interval = new ClosedInterval(DOMAIN_FIRST_ENDPOINT_FOR_FIRST_VARIABLE, DOMAIN_SECOND_ENDPOINT_FOR_FIRST_VARIABLE);
        domain.add(interval);
        interval = new ClosedInterval(DOMAIN_FIRST_ENDPOINT_FOR_SECOND_VARIABLE, DOMAIN_SECOND_ENDPOINT_FOR_SECOND_VARIABLE);
        domain.add(interval);
        return domain;
    }
}
